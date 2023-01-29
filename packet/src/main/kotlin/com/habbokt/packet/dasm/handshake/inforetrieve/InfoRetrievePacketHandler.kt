package com.habbokt.packet.dasm.handshake.inforetrieve

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.userobject.UserObjectPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrievePacketHandler : PacketHandler<InfoRetrieveProxyPacket>(
    handler = {
        writePacket(
            UserObjectPacket(
                userId = it.id, // "1"
                name = it.name, // "jordan"
                figure = it.figure, // "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-"
                sex = it.sex, // "F"
                customData = it.motto,
                phTickets = 0,
                phFigure = "",
                photoFilm = 1,
                directMail = 0,
                respectTicketTotal = 0,
                respectTicketCount = 0
            )
        )
    }
)