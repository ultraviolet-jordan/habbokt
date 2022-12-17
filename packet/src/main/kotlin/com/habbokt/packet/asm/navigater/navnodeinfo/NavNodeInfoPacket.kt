package com.habbokt.packet.asm.navigater.navnodeinfo

import com.habbokt.api.packet.Packet
import com.habbokt.api.room.Room

/**
 * @author Jordan Abraham
 */
data class NavNodeInfoPacket(
    val mask: Int,
    val id: Int,
    val type: Int,
    val name: String,
    val userCount: Int,
    val maxUsers: Int,
    val parentId: Int,
    val rooms: List<Room>
) : Packet