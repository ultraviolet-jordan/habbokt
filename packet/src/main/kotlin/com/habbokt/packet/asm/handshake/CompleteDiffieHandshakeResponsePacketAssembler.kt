package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeResponsePacketAssembler : PacketAssembler<CompleteDiffieHandshakeResponsePacket>(Assembler(id = 1) {
    it.putStringHabbo(secretKey)
})