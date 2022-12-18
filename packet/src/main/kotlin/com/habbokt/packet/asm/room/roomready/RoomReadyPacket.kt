package com.habbokt.packet.asm.room.roomready

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class RoomReadyPacket(
    val worldType: String,
    val unitId: Int
) : Packet