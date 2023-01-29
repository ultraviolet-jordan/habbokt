package com.habbokt.packet.dasm.room.gusrs

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GUsrsProxyPacketHandler : ProxyPacketHandler<GUsrsPacket, GUsrsProxyPacket>(
    handler = { GUsrsProxyPacket.Empty }
)