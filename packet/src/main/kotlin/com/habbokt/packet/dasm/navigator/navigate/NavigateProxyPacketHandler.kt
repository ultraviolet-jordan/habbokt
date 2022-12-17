package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigateProxyPacketHandler : ProxyPacketHandler<NavigatePacket>(ProxyHandler {
    return@ProxyHandler NavigateProxyPacket()
})