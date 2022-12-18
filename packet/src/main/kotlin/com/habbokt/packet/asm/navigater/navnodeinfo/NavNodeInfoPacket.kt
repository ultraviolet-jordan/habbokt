package com.habbokt.packet.asm.navigater.navnodeinfo

import com.habbokt.api.packet.Packet
import com.habbokt.api.room.RoomCategory
import com.habbokt.api.room.RoomSubCategory

/**
 * @author Jordan Abraham
 */
data class NavNodeInfoPacket(
    val mask: Int,
    val category: RoomCategory,
    val subCategories: List<RoomSubCategory>,
) : Packet