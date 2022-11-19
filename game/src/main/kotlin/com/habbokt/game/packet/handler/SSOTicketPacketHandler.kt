package com.habbokt.game.packet.handler

import com.habbokt.api.etc.DisconnectReason
import com.habbokt.api.inject
import com.habbokt.api.packet.AuthenticationOKPacket
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.SSOTicketPacket
import com.habbokt.api.packet.UserRightsPacket
import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
private val playersService by inject<PlayersService>()

fun PacketHandlerConfig.installSSOTicketPacket() {
    packet<SSOTicketPacket> {
        val ssoTicket = packet.ssoTicket

        val player = playersService.ssoTicket(ssoTicket)
        if (player == null) {
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
            return@packet
        }

        if (player.ssoTicket != ssoTicket) {
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
            return@packet
        }

        if (!playersService.editPlayer(player.copy(ssoTicket = ""))) {
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
            return@packet
        }

        client.writePacket(UserRightsPacket())
        client.writePacket(AuthenticationOKPacket())
    }
}