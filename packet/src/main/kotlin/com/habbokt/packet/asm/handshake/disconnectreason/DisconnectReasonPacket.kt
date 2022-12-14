package com.habbokt.packet.asm.handshake.disconnectreason

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: Int
) : Packet