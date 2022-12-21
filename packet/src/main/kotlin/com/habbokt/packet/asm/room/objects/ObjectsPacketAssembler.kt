package com.habbokt.packet.asm.room.objects

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ObjectsPacketAssembler : PacketAssembler<ObjectsPacket>(Assembler(id = 30) {
    it.putIntHabbo(objects.size)
})