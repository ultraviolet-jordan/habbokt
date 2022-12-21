package com.habbokt.packet.asm.room.activeobjects

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ActiveObjectsPacketAssembler : PacketAssembler<ActiveObjectsPacket>(Assembler(id = 32) {
    it.putIntHabbo(objects.size)
})