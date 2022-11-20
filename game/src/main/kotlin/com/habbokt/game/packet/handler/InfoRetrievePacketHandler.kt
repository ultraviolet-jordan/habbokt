package com.habbokt.game.packet.handler

import com.habbokt.api.packet.InfoRetrievePacket
import com.habbokt.api.packet.UserObjectPacket
import com.habbokt.api.packet.handler.handler

/**
 * @author Jordan Abraham
 */
val InfoRetrievePacketHandler = handler<InfoRetrievePacket> {
    val player = client.getPlayer() ?: return@handler

    client.writePacket(UserObjectPacket(
        userId = player.id().toString(),
        name = player.username(),
        figure = player.appearance(),
        sex = player.gender(),
        customData = "Test Motto",
        phTickets = 0,
        phFigure = "",
        photoFilm = 1,
        directMail = 0,
        respectTicketTotal = 0,
        respectTicketCount = 0
    ))
}