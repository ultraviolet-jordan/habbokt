package com.habbokt.game.packet.handler

import com.habbokt.api.packet.handler.PacketHandlerListener
import com.habbokt.game.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.game.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.game.uuid

/**
 * @author Jordan Abraham
 */
fun PacketHandlerListener.initDiffieHandshakePacket() {
    handlePacket<InitDiffieHandshakeRequestPacket> {
        client.writePacket(
            InitDiffieHandshakeResponsePacket(
                securityCastToken = uuid(32),
                serverToClient = packet.value // Always 0
            )
        )
    }
}