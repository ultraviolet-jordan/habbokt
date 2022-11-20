package com.habbokt.api.packet

import com.habbokt.api.client.DisconnectReason

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: DisconnectReason
) : Packet