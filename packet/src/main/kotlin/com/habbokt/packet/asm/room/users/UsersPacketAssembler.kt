package com.habbokt.packet.asm.room.users

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UsersPacketAssembler : PacketAssembler<UsersPacket>(Assembler(id = 28) {
    it.putIntHabbo(players.size)
})