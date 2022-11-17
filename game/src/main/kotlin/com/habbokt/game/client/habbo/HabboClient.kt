package com.habbokt.game.client.habbo

import com.habbokt.game.buffer.base64
import com.habbokt.game.client.Client
import com.habbokt.game.packet.Packet
import com.habbokt.game.packet.assembler.PacketAssemblerListener
import com.habbokt.game.packet.disassembler.PacketDisassemblerListener
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
class HabboClient(
    private val readChannel: ByteReadChannel,
    private val writeChannel: ByteWriteChannel
) : Client {
    private val writePool = ByteBuffer.allocateDirect(256)

    override fun readChannel(): ByteReadChannel = readChannel
    override fun writeChannel(): ByteWriteChannel = writeChannel
    override fun bufferPool(): ByteBuffer = writePool

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
        return PacketDisassemblerListener[id]?.packet?.invoke(buffer)
    }

    override fun writePacket(packet: Packet) {
        // TODO Use the write pool properly. For now I am just writing back to client immediately.
        // TODO It should be pooling the data from multiple packets if possible then writing to client.
        val assembler = PacketAssemblerListener[packet::class] ?: return
        println("DEBUG Outgoing Packet: ID = ${assembler.id}, ASSEMBLER=${assembler}")
        writePool.put(assembler.id.base64(2)) // Write packet id.
        assembler.packet.invoke(packet, writePool) // Invoke packet body.
        writePool.put(1) // End packet.

        if (writeChannel.isClosedForWrite) return
        writeChannel.apply {
            runBlocking(Dispatchers.IO) {
                writeFully(writePool.flip())
            }
        }.flush()
        writePool.clear()
    }
}