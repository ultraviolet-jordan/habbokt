package com.habbokt.game.packet.handler

import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet
import com.habbokt.game.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.game.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.game.uuid

/**
 * @author Jordan Abraham
 */
fun PacketHandlerConfig.installCompleteDiffieHandshakePacket() {
    packet<CompleteDiffieHandshakeRequestPacket> {
        client.writePacket(
            CompleteDiffieHandshakeResponsePacket(
                secretKey = uuid(32)
            )
        )
    }
}