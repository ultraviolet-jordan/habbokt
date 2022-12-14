package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoProxyPacketHandler : ProxyPacketHandler<ScrGetUserInfoPacket>(ProxyHandler {
    ScrGetUserInfoProxyPacket(productName)
})