package com.habbokt.api.packet

/**
 * @author Jordan Abraham
 */
data class SSOTicketPacket(
    val ssoTicket: String
) : Packet