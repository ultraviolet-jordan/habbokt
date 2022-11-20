package com.habbokt.game.packet.handler

import com.habbokt.api.packet.*
import com.habbokt.api.packet.handler.*

/**
 * @author Jordan Abraham
 */
val InfoRetrievePacketHandler = handler<InfoRetrievePacket> {
    client.writePacket(UserObjectPacket(
        userId = "1",
        name = "Jordan",
        figure = "",
        sex = "F",
        customData = "Test Motto",
        phTickets = 0,
        phFigure = "",
        photoFilm = 1,
        directMail = 0,
        respectTicketTotal = 0,
        respectTicketCount = 0
    ))
}