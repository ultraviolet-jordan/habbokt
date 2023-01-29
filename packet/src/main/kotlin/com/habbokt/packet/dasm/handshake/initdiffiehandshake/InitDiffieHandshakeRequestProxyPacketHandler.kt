package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.common.Common.uuid
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeRequestProxyPacketHandler : ProxyPacketHandler<InitDiffieHandshakeRequestPacket, InitDiffieHandshakeRequestProxyPacket>(
    handler = {
        InitDiffieHandshakeRequestProxyPacket(
            securityCastToken = uuid(32),
            serverToClient = it.value
        )
    }
)