package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestProxyPacketHandler : ProxyPacketHandler<CompleteDiffieHandshakeRequestPacket>(ProxyHandler {
    // TODO Validate the incoming public key.
    CompleteDiffieHandshakeRequestProxyPacket(
        secretKey = uuid(32)
    )
})