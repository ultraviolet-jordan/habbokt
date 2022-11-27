package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestHandler : HandlerListener<CompleteDiffieHandshakeRequestPacket>(Handler {
    it.writePacket(
        CompleteDiffieHandshakeResponsePacket(
            secretKey = uuid(32)
        )
    )
})