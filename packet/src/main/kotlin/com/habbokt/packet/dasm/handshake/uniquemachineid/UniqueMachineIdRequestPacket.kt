package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class UniqueMachineIdRequestPacket(
    val machineId: String
) : Packet