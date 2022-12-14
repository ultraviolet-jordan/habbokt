package com.habbokt.packet.asm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeResponsePacketAssembler : PacketAssembler<InitDiffieHandshakeResponsePacket>(Assembler(id = 277) {
    it.putStringHabbo(securityCastToken)
    it.putIntHabbo(serverToClient)
})