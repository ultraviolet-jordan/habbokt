package com.habbokt.game.packet.handler

import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet
import com.habbokt.api.packet.SSOTicketPacket

/**
 * @author Jordan Abraham
 */
fun PacketHandlerConfig.installSSOTicketPacket() {
    packet<SSOTicketPacket> {
        val ssoTicket = packet.ssoTicket
        println(ssoTicket)
    }
}