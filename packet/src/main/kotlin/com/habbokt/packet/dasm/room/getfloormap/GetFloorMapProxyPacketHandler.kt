package com.habbokt.packet.dasm.room.getfloormap

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetFloorMapProxyPacketHandler : ProxyPacketHandler<GetFloorMapPacket>(ProxyHandler {
    GetFloorMapProxyPacket.Empty
})