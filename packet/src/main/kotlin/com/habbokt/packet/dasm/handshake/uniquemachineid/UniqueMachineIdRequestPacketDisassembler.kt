package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdRequestPacketDisassembler : PacketDisassembler(Disassembler {
    UniqueMachineIdRequestPacket(
        machineId = it.getStringHabbo()
    )
})