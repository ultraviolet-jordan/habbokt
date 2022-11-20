package com.habbokt.api.packet

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