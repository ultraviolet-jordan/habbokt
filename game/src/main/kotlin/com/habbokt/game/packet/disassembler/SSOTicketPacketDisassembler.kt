package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installSSOTicketPacket() {
    packet(id = 204) {
        SSOTicketPacket(
            ssoTicket = it.getStringHabbo()
        )
    }
}
