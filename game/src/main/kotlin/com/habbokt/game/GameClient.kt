package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.common.base64
import com.habbokt.api.packet.Packet
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
class GameClient(
    private val readChannel: ByteReadChannel,
    private val writeChannel: ByteWriteChannel
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
        TODO("Not yet implemented")
    }
}