package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestDisassembler : DisassemblerListener(Disassembler(id = 2002) {
    CompleteDiffieHandshakeRequestPacket(
        publicKey = it.getStringHabbo()
    )
})