package com.habbokt.packet.asm.handshake.uniquemachineid

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class UniqueMachineIdResponsePacket(
    val machineId: String
) : Packet