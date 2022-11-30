package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.UserObjectPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrievePacketHandler : PacketHandler<InfoRetrievePacket>(Handler {
    val player = it.player() ?: return@Handler it.close()
    val details = player.details

    it.writePacket(
        UserObjectPacket(
            userId = details.id.toString(), // "1"
            name = details.username, // "jordan"
            figure = details.appearance, // "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-"
            sex = details.gender, // "F"
            customData = "Test Motto",
            phTickets = 0,
            phFigure = "",
            photoFilm = 1,
            directMail = 0,
            respectTicketTotal = 0,
            respectTicketCount = 0
        )
    )
})