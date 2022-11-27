package com.habbokt.packet

import com.habbokt.api.client.DisconnectReason
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: DisconnectReason
) : Packet