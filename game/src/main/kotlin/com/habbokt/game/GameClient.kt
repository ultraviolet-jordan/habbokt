package com.habbokt.game

import com.habbokt.api.buffer.base64
import com.habbokt.api.client.Client
import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.assembler.PacketAssembler
import com.habbokt.api.packet.disassembler.PacketDisassembler
import com.habbokt.api.packet.handler.PacketHandler
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlin.reflect.KClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
class GameClient(
    private val readChannel: ByteReadChannel,
    private val writeChannel: ByteWriteChannel,
    private val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    private val disassemblers: Map<Int, PacketDisassembler>,
    private val handlers: Map<KClass<*>, suspend PacketHandler<Packet>.() -> Unit>
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
        return disassemblers[id]?.packet?.invoke(buffer)
    }

    override suspend fun handlePacket(packet: Packet) {
        val handler = PacketHandler(this, packet)
        handlers[handler.packet::class]?.invoke(handler)
    }

    override fun writePacket(packet: Packet) {
        // TODO Use the write pool properly. For now I am just writing back to client immediately.
        // TODO It should be pooling the data from multiple packets if possible then writing to client.
        val assembler = assemblers[packet::class] ?: return
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