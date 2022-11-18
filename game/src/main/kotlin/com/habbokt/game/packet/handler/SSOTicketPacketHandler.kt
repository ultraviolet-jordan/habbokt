package com.habbokt.game.packet.handler

import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet

/**
 * @author Jordan Abraham
 */
fun PacketHandlerConfig.installSSOTicketPacket() {
    packet<SSOTicketPacket> {
        val ssoTicket = packet.ssoTicket
        println(ssoTicket)
    }
}