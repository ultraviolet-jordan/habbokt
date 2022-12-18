package com.habbokt.packet.dasm.room.getinterst

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetInterstProxyPacketHandler : ProxyPacketHandler<GetInterstPacket>(ProxyHandler {
    return@ProxyHandler GetInterstProxyPacket(parameter)
})