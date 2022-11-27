package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: Int
) : Packet