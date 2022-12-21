package com.habbokt.packet.asm.navigater.recommendroomlist

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RecommendRoomListPacketAssembler : PacketAssembler<RecommendRoomListPacket>(Assembler(id = 351) {
    require(rooms.size <= 3)
    it.putIntHabbo(rooms.size)
    rooms.forEach { room ->
        it.putIntHabbo(room.id)
        it.putStringHabbo(room.name)
        it.putStringHabbo(room.owner)
        it.putStringHabbo("open") // TODO
        it.putIntHabbo(room.userCount)
        it.putIntHabbo(room.maxUsers)
        it.putStringHabbo(room.description)
    }
})