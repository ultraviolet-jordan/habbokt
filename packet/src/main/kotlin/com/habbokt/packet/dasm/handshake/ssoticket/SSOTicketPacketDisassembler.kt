package com.habbokt.packet.dasm.handshake.ssoticket

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketPacketDisassembler : PacketDisassembler<SSOTicketPacket>(
    body = {
        SSOTicketPacket(
            ssoTicket = getStringHabbo()
        )
    }
)