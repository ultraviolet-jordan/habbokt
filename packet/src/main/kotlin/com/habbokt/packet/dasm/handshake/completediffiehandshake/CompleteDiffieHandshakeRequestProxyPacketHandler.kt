package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestProxyPacketHandler : ProxyPacketHandler<CompleteDiffieHandshakeRequestPacket, CompleteDiffieHandshakeRequestProxyPacket>(
    handler = {
        // TODO Validate the incoming public key.
        CompleteDiffieHandshakeRequestProxyPacket(
            secretKey = uuid(32)
        )
    }
)