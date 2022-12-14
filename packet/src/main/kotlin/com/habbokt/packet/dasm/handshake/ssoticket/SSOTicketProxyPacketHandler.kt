package com.habbokt.packet.dasm.handshake.ssoticket

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketProxyPacketHandler @Inject constructor(
    private val playersService: PlayersService
) : ProxyPacketHandler<SSOTicketPacket>(ProxyHandler {
    val playerDAO = playersService.ssoTicket(ssoTicket)
    return@ProxyHandler when {
        playerDAO == null -> null
        playerDAO.ssoTicket != ssoTicket -> null
        !playersService.editPlayer(playerDAO.copy(ssoTicket = "")) -> null
        else -> SSOTicketProxyPacket(playerDAO.id)
    }
//    when {
//        playerDAO == null -> Disconnect
//        playerDAO.ssoTicket != ssoTicket -> Disconnect
//        !playersService.editPlayer(playerDAO.copy(ssoTicket = "")) -> Disconnect
//        else -> null
//    }?.let { disconnectReason ->
//        it.writePacket(DisconnectReasonPacket(disconnectReason.id))
//    } ?: run {
//        require(playerDAO != null)
//        it.authenticate(playerDAO.id)
//    }
})