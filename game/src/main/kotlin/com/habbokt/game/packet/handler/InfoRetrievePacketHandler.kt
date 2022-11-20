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
        userId = player.id().toString(), // "1"
        name = player.username(), // "jordan"
        figure = player.appearance(), // "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-"
        sex = player.gender(), // "F"
        customData = "Test Motto",
        phTickets = 0,
        phFigure = "",
        photoFilm = 1,
        directMail = 0,
        respectTicketTotal = 0,
        respectTicketCount = 0
    ))
}