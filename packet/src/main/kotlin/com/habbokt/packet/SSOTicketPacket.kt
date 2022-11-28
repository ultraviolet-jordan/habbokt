package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class SSOTicketPacket(
    val ssoTicket: String
) : Packet