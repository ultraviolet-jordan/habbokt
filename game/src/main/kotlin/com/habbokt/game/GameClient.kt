package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.buf.base64
import com.habbokt.packet.dasm.PacketDisassembler
import com.habbokt.packet.handler.PacketHandler
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
class GameClient(
    private val socket: Socket,
    private val assemblers: List<PacketAssembler<Packet>>,
    private val disassemblers: List<PacketDisassembler>,
    private val handlers: List<PacketHandler<Packet>>
) : Client {
    private val readChannel = socket.openReadChannel()
    private val writeChannel = socket.openWriteChannel()
    private val writePool = ByteBuffer.allocateDirect(256)
    private lateinit var connectedPlayer: Player

    override suspend fun awaitPacket(): Packet? {
        if (readChannel.isClosedForRead) {
            return null
        }
        if (readChannel.availableForRead < 5) {
            readChannel.awaitContent()
        }
        val size = ByteArray(3) { readChannel.readByte() }.base64()
        if (readChannel.availableForRead < size || size < 0) {
            if (size > 0) {
                readChannel.discard(size.toLong())
            }
            return null
        }

        val buffer = ByteBuffer.wrap(readChannel.readPacket(size).readBytes())
        val id = String(ByteArray(2) { buffer.get() }).toByteArray().base64()

        println("DEBUG Incoming Packet: ID=$id, SIZE=$size, REMAINING=${buffer.remaining()}")

        return disassemblers
            .firstOrNull { it.disassembler.id == id }
            ?.disassembler
            ?.packet
            ?.invoke(buffer)
    }

    override fun handlePacket(packet: Packet) {
        runBlocking {
            handlers
                .firstOrNull { it.typeOf(packet) }
                ?.handler
                ?.block
                ?.invoke(packet, this@GameClient)
        }
    }

    override fun writePacket(packet: Packet) {
        // TODO Use the write pool properly. For now I am just writing back to client immediately.
        // TODO It should be pooling the data from multiple packets if possible then writing to client.
        val assembler = assemblers.firstOrNull { it.typeOf(packet) }?.assembler ?: return

        println("DEBUG Outgoing Packet: ID = ${assembler.id}, ASSEMBLER=${assembler}")

        writePool.put(assembler.id.base64(2)) // Write packet id.
        assembler.block.invoke(packet, writePool) // Invoke packet body.
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

    override fun player(): Player? {
        if (!::connectedPlayer.isInitialized) return null
        return connectedPlayer
    }

    override fun close() {
        socket.close()
    }
}