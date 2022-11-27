package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.SessionParametersRequestPacket
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestDisassembler : DisassemblerListener(Disassembler(id = 1817) {
    SessionParametersRequestPacket()
})