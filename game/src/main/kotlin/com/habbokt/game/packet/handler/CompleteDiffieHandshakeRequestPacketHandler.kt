package com.habbokt.game.packet.handler

import com.habbokt.api.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.api.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.api.packet.handler.*
import com.habbokt.game.uuid

/**
 * @author Jordan Abraham
 */
val CompleteDiffieHandshakeRequestPacketHandler = handler<CompleteDiffieHandshakeRequestPacket> {
    client.writePacket(
        CompleteDiffieHandshakeResponsePacket(
            secretKey = uuid(32)
        )
    )
}