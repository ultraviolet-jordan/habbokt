package com.habbokt.packet.dasm.room.getroomad

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRoomAdProxyPacketHandler : ProxyPacketHandler<GetRoomAdPacket, GetRoomAdProxyPacket>(
    handler = { GetRoomAdProxyPacket.Empty }
)