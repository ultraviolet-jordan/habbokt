package com.habbokt.packet.dasm.room.getroomad

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.roomad.RoomAdPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRoomAdPacketHandler : PacketHandler<GetRoomAdProxyPacket>(
    handler = { writePacket(RoomAdPacket.Empty) }
)