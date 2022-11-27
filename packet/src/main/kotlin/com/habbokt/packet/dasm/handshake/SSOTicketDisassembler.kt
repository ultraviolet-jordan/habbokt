package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.SSOTicketPacket
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketDisassembler : DisassemblerListener(Disassembler(id = 204) {
    SSOTicketPacket(
        ssoTicket = it.getStringHabbo()
    )
})