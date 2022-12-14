package com.habbokt.packet.dasm.handshake.ssoticket

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class SSOTicketPacket(
    val ssoTicket: String
) : Packet