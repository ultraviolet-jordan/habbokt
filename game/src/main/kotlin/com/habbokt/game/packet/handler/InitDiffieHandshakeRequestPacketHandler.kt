package com.habbokt.game.packet.handler

import com.habbokt.api.common.uuid
import com.habbokt.api.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.api.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.api.packet.handler.handler

/**
 * @author Jordan Abraham
 */
val InitDiffieHandshakeRequestPacketHandler = handler<InitDiffieHandshakeRequestPacket> {
    client.writePacket(
        InitDiffieHandshakeResponsePacket(
            securityCastToken = uuid(32),
            serverToClient = packet.value // Always 0
        )
    )
}