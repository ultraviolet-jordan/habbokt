package com.habbokt.packet.asm.room.users

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UsersPacketAssembler : PacketAssembler<UsersPacket>(
    id = 28,
    body = {
        putIntHabbo(it.players.size)
    }
)