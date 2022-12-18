package com.habbokt.packet.asm.room.roomready

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomReadyPacketAssembler : PacketAssembler<RoomReadyPacket>(Assembler(id = 69) {
    it.putStringHabbo(worldType)
    it.putIntHabbo(unitId)
})