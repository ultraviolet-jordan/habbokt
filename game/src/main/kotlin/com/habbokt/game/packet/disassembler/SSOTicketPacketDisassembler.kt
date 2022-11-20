package com.habbokt.game.packet.disassembler

import com.habbokt.api.common.getStringHabbo
import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.disassembler.disassembler

/**
 * @author Jordan Abraham
 */
val SSOTicketPacketDisassembler = disassembler(id = 204) {
    SSOTicketPacket(
        ssoTicket = it.getStringHabbo()
    )
}
