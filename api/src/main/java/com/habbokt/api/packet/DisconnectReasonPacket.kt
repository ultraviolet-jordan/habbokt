package com.habbokt.api.packet

import com.habbokt.api.etc.DisconnectReason

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: DisconnectReason
) : Packet