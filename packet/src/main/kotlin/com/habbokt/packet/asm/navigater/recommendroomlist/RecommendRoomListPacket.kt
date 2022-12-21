package com.habbokt.packet.asm.navigater.recommendroomlist

import com.habbokt.api.packet.Packet
import com.habbokt.api.room.Room

/**
 * @author Jordan Abraham
 */
data class RecommendRoomListPacket(
    val rooms: List<Room>
) : Packet