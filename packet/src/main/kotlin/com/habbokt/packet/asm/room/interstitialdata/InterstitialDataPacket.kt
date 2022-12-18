package com.habbokt.packet.asm.room.interstitialdata

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InterstitialDataPacket(
    val sourceUrl: String,
    val targetUrl: String
) : Packet {
    companion object {
        val Empty = InterstitialDataPacket(sourceUrl = "", targetUrl = "")
    }
}