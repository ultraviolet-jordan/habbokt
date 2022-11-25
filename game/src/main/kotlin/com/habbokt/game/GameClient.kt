package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.packet.Packet
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
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
        TODO("Not yet implemented")
    }

    override fun handlePacket(packet: Packet) {
        TODO("Not yet implemented")
    }

    override fun writePacket(packet: Packet) {
        TODO("Not yet implemented")
    }
}