package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UniqueMachineIdPacket
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdPacketDisassembler : PacketDisassembler(Disassembler(id = 813) {
    UniqueMachineIdPacket(
        machineId = it.getStringHabbo()
    )
})