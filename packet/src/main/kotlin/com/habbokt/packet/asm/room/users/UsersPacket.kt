package com.habbokt.packet.asm.room.users

import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class UsersPacket(
    val players: List<Player>
) : Packet