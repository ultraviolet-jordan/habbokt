package com.habbokt.packet.asm.room.roomad

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class RoomAdPacket(
    val sourceUrl: String,
    val targetUrl: String
) : Packet {
    companion object {
        val Empty = RoomAdPacket(sourceUrl = "", targetUrl = "")
    }
}