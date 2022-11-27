package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UniqueMachineIdPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdAssembler : AssemblerListener<UniqueMachineIdPacket>(Assembler(id = 439) {
    it.putStringHabbo(machineId)
})