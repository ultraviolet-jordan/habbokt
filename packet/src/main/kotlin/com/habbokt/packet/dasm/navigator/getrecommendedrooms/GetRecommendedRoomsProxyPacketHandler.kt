package com.habbokt.packet.dasm.navigator.getrecommendedrooms

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRecommendedRoomsProxyPacketHandler : ProxyPacketHandler<GetRecommendedRoomsPacket>(ProxyHandler {
    GetRecommendedRoomsProxyPacket.Empty
})