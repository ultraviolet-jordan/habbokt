package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet
import com.habbokt.packet.ClientHelloPacket
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.buf.base64
import com.habbokt.packet.dasm.PacketDisassembler
import com.habbokt.packet.handler.PacketHandler
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlin.reflect.KClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author Jordan Abraham
 */
class GameClient constructor(
    private val environment: ApplicationEnvironment,
    private val socket: Socket,
    private val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    private val disassemblers: Map<Int, PacketDisassembler>,
    private val handlers: Map<KClass<*>, PacketHandler<Packet>>
) : Client {
    private val readChannel = socket.openReadChannel()
    private val writeChannel = socket.openWriteChannel()
    private val writePool = ByteBuffer.allocateDirect(256)
    private lateinit var connectedPlayer: Player

    override suspend fun accept() {
        try {
            writePacket(ClientHelloPacket())
            while (true) {
                handlePacket(packet = awaitPacket() ?: continue)
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
        val header = readChannel.readPacket(5)
        val size = header.readBytes(3).base64() - Short.SIZE_BYTES
        val id = header.readBytes(2).base64()

        if (readChannel.availableForRead < size) {
            if (size > 0) {
                readChannel.discard(readChannel.availableForRead.toLong())
            }
            return null
        }

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

    override fun handlePacket(packet: Packet) {
        runBlocking {
            handlers[packet::class]
                ?.handler
                ?.block
                ?.invoke(packet, this@GameClient)
        }
    }

    override fun writePacket(packet: Packet) {
        // TODO Use the write pool properly. For now I am just writing back to client immediately.
        // TODO It should be pooling the data from multiple packets if possible then writing to client.
        val (id, block) = assemblers[packet::class]?.assembler ?: return

        environment.log.info("Outgoing Packet: Id=$id, Packet=$packet")

        writePool.put(id.base64(2)) // Write packet id.
        block.invoke(packet, writePool) // Invoke packet body.
        writePool.put(1) // End packet.

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
        socket.close()
    }
}