package com.habbokt.packet.handler.handshake

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.UserObjectPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrievePacketHandler @Inject constructor(
    private val playersService: PlayersService
) : PacketHandler<InfoRetrievePacket>(Handler {
    val player = it.player() ?: return@Handler it.close()
    val (id, name, _, _, figure, sex, _, motto) = playersService.player(player.id) ?: return@Handler it.close()

    it.writePacket(
        UserObjectPacket(
            userId = id.toString(), // "1"
            name = name, // "jordan"
            figure = figure, // "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-"
            sex = sex, // "F"
            customData = motto,
            phTickets = 0,
            phFigure = "",
            photoFilm = 1,
            directMail = 0,
            respectTicketTotal = 0,
            respectTicketCount = 0
        )
    )
})