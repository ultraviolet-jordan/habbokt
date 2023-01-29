package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoProxyPacketHandler : ProxyPacketHandler<ScrGetUserInfoPacket, ScrGetUserInfoProxyPacket>(
    handler = {
        ScrGetUserInfoProxyPacket(
            productName = it.productName
        )
    }
)