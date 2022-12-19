package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.api.packet.ProxyPacket
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.packet.asm.handshake.clienthello.ClientHelloPacket
import com.habbokt.packet.buf.base64
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.SocketAddress
import io.ktor.network.sockets.isClosed
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.util.logging.error
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlin.reflect.KClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * @author Jordan Abraham
 */
class GameClient constructor(
    private val environment: ApplicationEnvironment,
    private val socket: Socket,
    private val gameServer: GameServer,
    private val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    private val disassemblers: Map<Int, PacketDisassembler>,
    private val handlers: Map<KClass<*>, PacketHandler<ProxyPacket>>,
    private val proxies: Map<KClass<*>, ProxyPacketHandler<Packet>>
) : Client {
    private val readChannel = socket.openReadChannel()
    private val writeChannel = socket.openWriteChannel()
    private val readPool = HashMap<ProxyPacket, Handler<ProxyPacket>>()
    private val writePool = ByteBuffer.allocateDirect(1024)
    private lateinit var connectedPlayer: Player

    override suspend fun accept() {
        try {
            // Immediately say hello and process the pool.
            writePacket(ClientHelloPacket())
            processWritePool()

            while (true) {
                // 30 seconds timeout to disconnect the client connection is nothing gets read.
                withTimeout(30_000) {
                    // Await incoming packet from client.
                    val packet = awaitPacket() ?: return@withTimeout
                    // Get associated proxy handler with packet.
                    // We process proxy handlers on the client coroutine thread since these are suspended.
                    // The data gets built out into another type of read packet which gets processed by the game thread.
                    val proxyHandler = proxies[packet::class]?.handler ?: return@withTimeout
                    // Invoke the proxy handler and return the packet.
                    val proxyPacket = proxyHandler.block.invoke(packet, this@GameClient) ?: return@withTimeout
                    // Get real packet handler from the proxy packet.
                    val handler = handlers[proxyPacket::class]?.handler ?: return@withTimeout
                    // Add the handler to the read pool queue.
                    synchronized(readPool) {
                        readPool[proxyPacket] = handler
                    }
                }
            }
        } catch (exception: Exception) {
            withContext(Dispatchers.IO) {
                close()
            }
            environment.log.error(exception.message)
        }
    }

    override suspend fun awaitPacket(): Packet? {
        if (readChannel.isClosedForRead) {
            readChannel.discard(readChannel.availableForRead.toLong())
            return null
        }
        if (readChannel.availableForRead < 5) {
            readChannel.awaitContent()
        }
        // Read a packet of 5 bytes.
        val header = readChannel.readPacket(5)
        // The size of the packet - the 2 because the packet id is read after the size.
        val size = header.readBytes(3).base64() - Short.SIZE_BYTES
        // Read the packet id.
        val id = header.readBytes(2).base64()
        header.release()

        if (readChannel.availableForRead < size) {
            if (size > 0) {
                readChannel.discard(readChannel.availableForRead.toLong())
            }
            return null
        }

        // Read a packet of the number of bytes from the buffer according to the read packet size.
        val body = readChannel.readPacket(size)

        environment.log.info("Incoming Packet: Header Id=$id, Body Size=${body.remaining}")

        val disassembler = disassemblers[id]?.disassembler
        if (disassembler == null) {
            body.discard(body.remaining)
            body.release()
            return null
        }

        return disassembler
            .packet
            .invoke(body)
            .also {
                // Require that the body was fully read from disassembler.
                require(body.endOfInput)
                body.release()
            }
    }

    override fun processReadPool() {
        if (readPool.isEmpty()) return
        synchronized(readPool) {
            readPool.onEach { it.value.block.invoke(it.key, this) }.clear()
        }
    }

    override fun writePacket(packet: Packet) {
        val (id, block) = assemblers[packet::class]?.assembler ?: return
        environment.log.info("Outgoing Packet: Id=$id, Packet=$packet")
        // Write packet id.
        writePool.put(id.base64(2))
        // Invoke packet body.
        block.invoke(packet, writePool)
        // End packet.
        writePool.put(1)
    }

    override fun processWritePool() {
        // Don't process if the write channel is closed.
        if (writeChannel.isClosedForWrite) return
        // Don't process if nothing is written to the write pool.
        if (writePool.position() == 0) return
        writeChannel.apply {
            runBlocking(Dispatchers.IO) {
                writeFully(writePool.flip())
            }
        }.flush()
        writePool.clear()
    }

    override fun authenticate(userId: Int) {
        this.connectedPlayer = GamePlayer(userId, this@GameClient).also {
            it.login()
        }
    }

    override fun player(): Player? = if (!::connectedPlayer.isInitialized) null else connectedPlayer

    override fun close() {
        if (!gameServer.connectionPool().drop(this)) {
            environment.log.info("Disconnected client was not part of the connection pool: ${socket.remoteAddress}")
        }
        environment.log.info("Disconnected client: ${socket.remoteAddress}")
        socket.close()
    }

    override fun connected(): Boolean = !socket.isClosed
    override fun socketAddress(): SocketAddress = socket.remoteAddress
}