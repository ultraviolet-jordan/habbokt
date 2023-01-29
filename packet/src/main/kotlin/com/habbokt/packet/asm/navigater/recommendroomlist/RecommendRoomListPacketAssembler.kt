package com.habbokt.packet.asm.navigater.recommendroomlist

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RecommendRoomListPacketAssembler : PacketAssembler<RecommendRoomListPacket>(
    id = 351,
    body = {
        require(it.rooms.size <= 3)
        putIntHabbo(it.rooms.size)
        it.rooms.forEach { room ->
            putIntHabbo(room.id)
            putStringHabbo(room.name)
            putStringHabbo(room.owner)
            putStringHabbo("open") // TODO
            putIntHabbo(room.userCount)
            putIntHabbo(room.maxUsers)
            putStringHabbo(room.description)
        }
    }
)