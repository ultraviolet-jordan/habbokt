package com.habbokt.packet.dasm.room.getfloormap

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetFloorMapProxyPacketHandler : ProxyPacketHandler<GetFloorMapPacket, GetFloorMapProxyPacket>(
    handler = { GetFloorMapProxyPacket.Empty }
)