package com.habbokt.game.packet.handler

import com.habbokt.api.client.DisconnectReason
import com.habbokt.api.client.handshake.LoginInformation
import com.habbokt.api.inject
import com.habbokt.api.packet.AuthenticationOKPacket
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.UserRightsPacket
import com.habbokt.api.packet.handler.handler
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
private val playersService by inject<PlayersService>()

val SSOTicketPacketHandler = handler<SSOTicketPacket> {
    val ssoTicket = packet.ssoTicket

    val playerDAO = playersService.ssoTicket(ssoTicket)
    if (playerDAO == null) {
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }

    if (playerDAO.ssoTicket != ssoTicket) {
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }

    if (!playersService.editPlayer(playerDAO.copy(ssoTicket = ""))) {
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }

    client.validateLogin(
        LoginInformation(
            id = playerDAO.id,
            username = playerDAO.username,
            password = playerDAO.password,
            email = playerDAO.email,
            appearance = playerDAO.appearance,
            gender = playerDAO.gender
        )
    )?.let {
        client.writePacket(UserRightsPacket())
        client.writePacket(AuthenticationOKPacket())
    } ?: run {
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
    }
}