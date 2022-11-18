package com.habbokt.api.packet

import com.habbokt.api.etc.DisconnectReason
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: DisconnectReason
) : Packet