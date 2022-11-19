package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val SSOTicketPacketDisassembler = disassembler(id = 204) {
    SSOTicketPacket(
        ssoTicket = it.getStringHabbo()
    )
}
