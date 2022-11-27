package com.habbokt.game

import com.habbokt.game.common.base64
import com.habbokt.packet.Packet
import com.habbokt.packet.asm.AssemblerListener
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
class GameClient(
    private val readChannel: ByteReadChannel,
    private val writeChannel: ByteWriteChannel,
    private val assemblers: List<AssemblerListener<Packet>>
) : Client {
    private val writePool = ByteBuffer.allocateDirect(256)

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
        return null // TODO
    }

    override fun handlePacket(packet: Packet) {
        TODO("Not yet implemented")
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
}