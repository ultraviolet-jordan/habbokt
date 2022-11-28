package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UniqueMachineIdPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdPacketAssembler : PacketAssembler<UniqueMachineIdPacket>(Assembler(id = 439) {
    it.putStringHabbo(machineId)
})