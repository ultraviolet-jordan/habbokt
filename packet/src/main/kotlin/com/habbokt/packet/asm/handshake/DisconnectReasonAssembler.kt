package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.DisconnectReasonPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class DisconnectReasonAssembler : AssemblerListener<DisconnectReasonPacket>(Assembler(id = 287) {
    it.putIntHabbo(reason)
})