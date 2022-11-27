package com.habbokt.packet.handler.handshake

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.client.DisconnectReason
import com.habbokt.dao.players.PlayersService
import com.habbokt.packet.AuthenticationOKPacket
import com.habbokt.packet.DisconnectReasonPacket
import com.habbokt.packet.SSOTicketPacket
import com.habbokt.packet.UserRightsPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketHandler @Inject constructor(
    private val playersService: PlayersService
) : HandlerListener<SSOTicketPacket>(Handler {

    val playerDAO = playersService.ssoTicket(ssoTicket)
    if (playerDAO == null) {
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect.id))
        return@Handler
    }

    if (playerDAO.ssoTicket != ssoTicket) {
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect.id))
        return@Handler
    }

    if (!playersService.editPlayer(playerDAO.copy(ssoTicket = ""))) {
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect.id))
        return@Handler
    }

    // Login Here
    it.writePacket(UserRightsPacket())
    it.writePacket(AuthenticationOKPacket())
})