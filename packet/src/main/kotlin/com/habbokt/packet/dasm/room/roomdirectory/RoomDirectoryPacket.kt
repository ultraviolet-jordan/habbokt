package com.habbokt.packet.dasm.room.roomdirectory

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class RoomDirectoryPacket(
    val typeId: Int,
    val roomId: Int,
    val doorId: Int
) : Packet