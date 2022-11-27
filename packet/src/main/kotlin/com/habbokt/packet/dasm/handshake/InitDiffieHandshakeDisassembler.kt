package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.packet.buf.getIntHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeDisassembler : DisassemblerListener(Disassembler(id = 206) {
    InitDiffieHandshakeRequestPacket(
        value = it.getIntHabbo()
    )
})