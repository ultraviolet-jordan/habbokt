package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdRequestPacketDisassembler : PacketDisassembler<UniqueMachineIdRequestPacket>(
    body = {
        UniqueMachineIdRequestPacket(
            machineId = getStringHabbo()
        )
    }
)