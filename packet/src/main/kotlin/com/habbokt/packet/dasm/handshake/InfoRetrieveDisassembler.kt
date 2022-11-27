package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrieveDisassembler : DisassemblerListener(Disassembler(id = 7) {
    InfoRetrievePacket()
})