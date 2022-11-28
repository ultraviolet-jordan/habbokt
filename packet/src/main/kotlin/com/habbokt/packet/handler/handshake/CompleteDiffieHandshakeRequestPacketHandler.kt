package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestPacketHandler : PacketHandler<CompleteDiffieHandshakeRequestPacket>(Handler {
    it.writePacket(
        CompleteDiffieHandshakeResponsePacket(
            secretKey = uuid(32)
        )
    )
})