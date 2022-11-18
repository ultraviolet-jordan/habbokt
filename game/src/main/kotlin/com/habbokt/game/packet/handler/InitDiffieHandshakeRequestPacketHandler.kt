package com.habbokt.game.packet.handler

import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet
import com.habbokt.game.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.game.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.game.uuid

/**
 * @author Jordan Abraham
 */
fun PacketHandlerConfig.installInitDiffieHandshakePacket() {
    packet<InitDiffieHandshakeRequestPacket> {
        client.writePacket(
            InitDiffieHandshakeResponsePacket(
                securityCastToken = uuid(32),
                serverToClient = packet.value // Always 0
            )
        )
    }
}