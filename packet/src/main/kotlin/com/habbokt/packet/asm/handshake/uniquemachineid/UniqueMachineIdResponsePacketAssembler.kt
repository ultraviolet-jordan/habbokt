package com.habbokt.packet.asm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdResponsePacketAssembler : PacketAssembler<UniqueMachineIdResponsePacket>(Assembler(id = 439) {
    it.putStringHabbo(machineId)
})