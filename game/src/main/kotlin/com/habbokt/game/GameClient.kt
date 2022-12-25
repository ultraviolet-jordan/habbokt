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
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import java.time.Duration
import java.util.concurrent.ArrayBlockingQueue
import kotlin.reflect.KClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext

/**
 * @author Jordan Abraham
 */
class GameClient constructor(
    private val applicationEnvironment: ApplicationEnvironment,
    private val socket: Socket,
    private val connectionPool: ConnectionPool,
    private val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    private val disassemblers: Map<Int, PacketDisassembler>,
    private val handlers: Map<KClass<*>, PacketHandler<ProxyPacket>>,
    private val proxies: Map<KClass<*>, ProxyPacketHandler<Packet>>
) : Client {
    private val readChannel = socket.openReadChannel()
    private val writeChannel = socket.openWriteChannel(autoFlush = true)
    private val readChannelPool = ArrayBlockingQueue<Pair<ProxyPacket, Handler<ProxyPacket>>>(8, true)
    private val writeChannelPool = ByteBuffer.allocateDirect(4096)
    private val remoteAddress = socket.remoteAddress
    private lateinit var connectedPlayer: Player

    override suspend fun accept() {
        try {
            // Immediately say hello and process the pool.
            writePacket(ClientHelloPacket())
            processWritePool()
            while (true) {
                // Timeout to disconnect the client connection is nothing gets read.
                val packet = withTimeout(Duration.ofSeconds(30)) { awaitPacket() } ?: continue
                // Get associated proxy handler with packet.
                // We process proxy handlers on the client coroutine thread since these are suspended.
                // The data gets built out into another type of read packet which gets processed by the game thread.
                val proxyHandler = proxies[packet::class]?.handler ?: continue
                // Invoke the proxy handler and return the packet.
                val proxyPacket = proxyHandler.block.invoke(packet, this) ?: continue
                // Get real packet handler from the proxy packet.
                val handler = handlers[proxyPacket::class]?.handler ?: continue
                // Add the handler to the read pool queue.
                withContext(Dispatchers.IO) {
                    // Inserts the specified element at the tail of this queue, waiting for space to become available if the queue is full.
                    readChannelPool.put(proxyPacket to handler)
                }
            }
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override suspend fun awaitPacket(): Packet? {
        if (readChannel.isClosedForRead) {
            readChannel.discard(readChannel.availableForRead.toLong())
            return null
        }
        if (readChannel.availableForRead < HEADER_SIZE_BYTES) {
            readChannel.awaitContent()
        }
        val header = readChannel.readPacket(HEADER_SIZE_BYTES)
        // The size of the packet - the 2 because the packet id is read after the size.
        val size = (header.readBytes(BODY_SIZE_BYTES).base64() - ID_SIZE_BYTES).also {
            if (readChannel.availableForRead < it) {
                readChannel.discard(readChannel.availableForRead.toLong())
                header.discard(header.remaining)
                header.release()
                return null
            }
        }
        val id = header.readBytes(ID_SIZE_BYTES).base64()
        header.release()

        // Read a packet of the number of bytes from the buffer according to the read packet size.
        val body = readChannel.readPacket(size)

        return disassemblers[id]
            ?.disassembler
            ?.packet
            ?.invoke(body)
            ?.also {
                // Require that the body was fully read from disassembler.
                require(body.endOfInput)
                body.release()
                applicationEnvironment.log.info("Disassembled read packet: Id=$id, Size=$size, $it")
            }
            ?: run {
                // Discard the body if the disassembler was not found for the packet.
                body.discard(body.remaining)
                body.release()
                applicationEnvironment.log.info("Discarded read packet: Id=$id, Size=$size")
                return@run null
            }
    }

    override fun processReadPool() {
        if (!connected()) return
        if (readChannelPool.isEmpty()) return
        // Atomically removes all the elements from this queue. The queue will be empty after this call returns.
        try {
            readChannelPool.onEach { it.second.block.invoke(it.first, this) }.clear()
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun writePacket(packet: Packet) {
        val (id, block) = assemblers[packet::class]?.assembler ?: return
        try {
            writeChannelPool.apply {
                put(id.base64(ID_SIZE_BYTES)) // Put packet id.
                val position = position()
                block.invoke(packet, this) // Put packet body.
                val size = writeChannelPool.position() - position
                put(1) // Put end packet.
                applicationEnvironment.log.info("Assembled write packet: Id=$id, Size=$size, $packet")
            }
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun processWritePool() {
        if (!connected()) return
        if (writeChannel.isClosedForWrite) return // Don't process if the write channel is closed.
        if (writeChannelPool.position() == 0) return // Don't process if nothing is written to the write pool.
        try {
            runBlocking(Dispatchers.IO) {
                // Write channel auto flushes on this write call.
                writeChannelPool.flip().also { writeChannel.writeAvailable(it) }.clear()
            }
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun authenticate(userId: Int) {
        this.connectedPlayer = GamePlayer(userId, this@GameClient).also {
            it.login()
        }
    }

    override fun player(): Player? = if (!::connectedPlayer.isInitialized) null else connectedPlayer

    override fun close() {
        if (!connectionPool.remove(this)) {
            applicationEnvironment.log.info("Disconnected client was not part of the connection pool: $remoteAddress")
        }
        applicationEnvironment.log.info("Disconnected client: $remoteAddress")
        socket.close()
    }

    override fun connected(): Boolean = !socket.isClosed
    override fun socketAddress(): SocketAddress = remoteAddress

    private companion object {
        /**
         * The number of bytes used to represent a packet body.
         */
        const val BODY_SIZE_BYTES = 3

        /**
         * The number of bytes used to represent a packet id.
         */
        const val ID_SIZE_BYTES = 2

        /**
         * The number of bytes used to represent a packet header.
         */
        const val HEADER_SIZE_BYTES = BODY_SIZE_BYTES + ID_SIZE_BYTES
    }
}