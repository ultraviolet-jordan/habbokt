package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapProxyPacketHandler : ProxyPacketHandler<GHMapPacket, GHMapProxyPacket>(
    handler = { GHMapProxyPacket.Empty }
)