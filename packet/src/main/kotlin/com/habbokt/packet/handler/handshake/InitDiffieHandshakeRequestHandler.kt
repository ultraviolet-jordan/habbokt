package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeRequestHandler : HandlerListener<InitDiffieHandshakeRequestPacket>(Handler {
    it.writePacket(
        InitDiffieHandshakeResponsePacket(
            securityCastToken = uuid(length = 32),
            serverToClient = value
        )
    )
})