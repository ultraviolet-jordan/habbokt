package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.UserObjectPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrieveHandler : HandlerListener<InfoRetrievePacket>(Handler {
    it.writePacket(
        UserObjectPacket(
            userId = "1", // "1"
            name = "jordan", // "jordan"
            figure = "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-", // "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-"
            sex = "F", // "F"
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