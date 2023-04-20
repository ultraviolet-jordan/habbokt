package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.api.packet.ProxyPacket
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.packet.asm.handshake.clienthello.ClientHelloPacket
import com.habbokt.packet.buf.getPacketBodySize
import com.habbokt.packet.buf.getPacketId
import com.habbokt.packet.buf.putPacketId
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.SocketAddress
import io.ktor.network.sockets.isClosed
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.utils.io.cancel
import io.ktor.utils.io.close
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext
import java.nio.ByteBuffer
import java.time.Duration
import java.util.concurrent.ArrayBlockingQueue
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
class GameClient constructor(
    private val applicationEnvironment: ApplicationEnvironment,
    private val socket: Socket,
    private val connectionPool: ConnectionPool,
    private val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    private val disassemblers: Map<Int, PacketDisassembler<Packet>>,
    private val handlers: Map<KClass<*>, PacketHandler<ProxyPacket>>,
    private val proxies: Map<KClass<*>, ProxyPacketHandler<Packet, ProxyPacket>>
) : Client {
    private val readChannel = socket.openReadChannel()
    private val writeChannel = socket.openWriteChannel()
    private val readChannelPool = ArrayBlockingQueue<Pair<ProxyPacket, Client.(ProxyPacket) -> Unit>>(8, true)
    private val writeChannelPool = ByteBuffer.allocateDirect(4096)
    private val remoteAddress = socket.remoteAddress
    private var connectedPlayer: Player? = null

    override suspend fun accept() {
        try {
            // Immediately say hello and process the pool.
            writePacket(ClientHelloPacket())
            processWritePool()
            while (true) {
                // Timeout to disconnect the client connection if nothing gets read within 30 seconds.
                // Suspends on awaitPacket until a packet is read from the client.
                val packet = withTimeout(Duration.ofSeconds(30)) { awaitPacket() } ?: continue
                // Get associated proxy handler with packet.
                // We process proxy handlers on the client coroutine thread since these are suspended.
                // The data gets built out into another type of read packet which gets processed by the game thread.
                val proxyHandler = proxies[packet::class]?.handler ?: continue
                // Invoke the proxy handler and return the packet.
                val proxyPacket = proxyHandler.invoke(this, packet) ?: continue
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
        if (!connected()) return null
        // 5 bytes are required to read a packet ID and SIZE.
        if (readChannel.availableForRead < 5) {
            readChannel.awaitContent()
        }
        val size = readChannel.getPacketBodySize() - 2
        if (readChannel.availableForRead < size + 2) {
            readChannel.discard(readChannel.availableForRead.toLong())
            return null
        }
        val packetId = readChannel.getPacketId()
        return disassemblers[packetId]
            ?.body
            ?.invoke(readChannel, size)
            ?.also {
                applicationEnvironment.log.info("Disassembled read packet: Id=$packetId, Size=$size, $it")
            }
            ?: run {
                // Discard the size amount of bytes if the disassembler was not found for the packet.
                readChannel.discard(size.toLong())
                applicationEnvironment.log.info("Discarded read packet: Id=$packetId, Size=$size")
                return@run null
            }
    }

    override fun processReadPool() {
        try {
            if (!connected() || readChannelPool.isEmpty()) return
            // Atomically removes all the elements from this queue. The queue will be empty after this call returns.
            readChannelPool.onEach { it.second.invoke(this, it.first) }.clear()
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun writePacket(packet: Packet) {
        try {
            val assembler = assemblers[packet::class] ?: return
            writeChannelPool.putPacketId(assembler.id)
            val position = writeChannelPool.position()
            assembler.body.invoke(writeChannelPool, packet) // Put packet body.
            val size = writeChannelPool.position() - position
            writeChannelPool.put(1) // Put end packet.
            applicationEnvironment.log.info("Assembled write packet: Id=${assembler.id}, Size=$size, $packet")
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun processWritePool() {
        try {
            if (!connected()) return
            if (writeChannelPool.position() == 0) return // Don't process if nothing is written to the write pool.
            runBlocking(Dispatchers.IO) {
                writeChannel.writeFully(writeChannelPool.flip())
                writeChannel.flush()
                writeChannelPool.clear()
            }
        } catch (exception: Exception) {
            close()
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }

    override fun authenticate(userId: Int) {
        this.connectedPlayer = GamePlayer(userId, client = this).also(Player::login)
    }

    override fun player(): Player? = connectedPlayer

    override fun close() {
        if (!connectionPool.remove(this)) {
            applicationEnvironment.log.info("Disconnected client was not part of the connection pool: $remoteAddress")
        }
        applicationEnvironment.log.info("Disconnected client: $remoteAddress")
        writeChannel.close()
        socket.close()
    }

    override fun connected(): Boolean = !socket.isClosed && !writeChannel.isClosedForWrite
    override fun socketAddress(): SocketAddress = remoteAddress
}