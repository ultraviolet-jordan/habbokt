package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeResponseAssembler : AssemblerListener<InitDiffieHandshakeResponsePacket>(Assembler(id = 277) {
    it.putStringHabbo(securityCastToken)
    it.putIntHabbo(serverToClient)
})