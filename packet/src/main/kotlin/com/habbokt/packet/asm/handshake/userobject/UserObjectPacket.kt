package com.habbokt.packet.asm.handshake.userobject

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class UserObjectPacket(
    val userId: String,
    val name: String,
    val figure: String,
    val sex: String,
    val customData: String,
    val phTickets: Int,
    val phFigure: String,
    val photoFilm: Int,
    val directMail: Int,
    val respectTicketTotal: Int,
    val respectTicketCount: Int
) : Packet