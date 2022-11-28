package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class ScrSendUserInfoPacket(
    val productName: String,
    val daysLeft: Int,
    val elapsedPeriods: Int,
    val prepaidPeriods: Int,
    val responseFlag: Int
) : Packet