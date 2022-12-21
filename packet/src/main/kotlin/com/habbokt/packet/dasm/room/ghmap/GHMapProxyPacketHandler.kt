package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapProxyPacketHandler : ProxyPacketHandler<GHMapPacket>(ProxyHandler {
    GHMapProxyPacket.Empty
})