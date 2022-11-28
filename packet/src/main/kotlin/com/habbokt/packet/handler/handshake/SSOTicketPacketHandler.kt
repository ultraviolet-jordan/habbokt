package com.habbokt.packet.handler.handshake

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.client.DisconnectReason.Disconnect
import com.habbokt.dao.players.PlayersService
import com.habbokt.packet.AuthenticationOKPacket
import com.habbokt.packet.DisconnectReasonPacket
import com.habbokt.packet.SSOTicketPacket
import com.habbokt.packet.UserRightsPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketPacketHandler @Inject constructor(
    private val playersService: PlayersService
) : PacketHandler<SSOTicketPacket>(Handler {
    val playerDAO = playersService.ssoTicket(ssoTicket)
    when {
        playerDAO == null -> Disconnect
        playerDAO.ssoTicket != ssoTicket -> Disconnect
        !playersService.editPlayer(playerDAO.copy(ssoTicket = "")) -> Disconnect
        else -> null
    }?.let { disconnectReason ->
        it.writePacket(DisconnectReasonPacket(disconnectReason.id))
    } ?: run {
        // Login Here
        it.writePacket(UserRightsPacket())
        it.writePacket(AuthenticationOKPacket())
    }
})