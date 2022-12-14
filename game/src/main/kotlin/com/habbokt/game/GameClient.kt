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
import io.ktor.network.sockets.isClosed
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentHashMap
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
    private val readPool = ConcurrentHashMap<ProxyPacket, Handler<ProxyPacket>>()
    private val writePool = ByteBuffer.allocateDirect(256)
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
                    readPool[proxyPacket] = handler
                }
            }
        } catch (exception: Exception) {
            withContext(Dispatchers.IO) {
                close()
            }
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

        if (readChannel.availableForRead < size) {
            if (size > 0) {
                readChannel.discard(readChannel.availableForRead.toLong())
            }
            return null
        }

        // Read a packet of the number of bytes from the buffer according to the read packet size.
        val body = readChannel.readPacket(size)

        environment.log.info("Incoming Packet: Header Id=$id, Body Size=${body.remaining}")

        return disassemblers[id]
            ?.disassembler
            ?.packet
            ?.invoke(ByteBuffer.wrap(body.readBytes()))
            .also {
                header.release()
                body.release()
            }
    }

    override fun processReadPool() {
        readPool.forEach {
            it.value.block.invoke(it.key, this)
        }
        readPool.clear()
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
        if (writeChannel.isClosedForWrite) return
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
        environment.log.info("Disconnected client: ${socket.remoteAddress}")
        gameServer.clients.remove(socket.remoteAddress.toString())
        socket.close()
    }

    override fun closed(): Boolean = socket.isClosed
}