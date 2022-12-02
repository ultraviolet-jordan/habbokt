package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.SSOTicketPacket
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketPacketDisassembler : PacketDisassembler(Disassembler {
    SSOTicketPacket(
        ssoTicket = it.getStringHabbo()
    )
})