package com.habbokt.packet.dasm.handshake.ssoticket

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
@Singleton
class SSOTicketProxyPacketHandler @Inject constructor(
    private val playersService: PlayersService
) : ProxyPacketHandler<SSOTicketPacket, SSOTicketProxyPacket>(
    handler = {
        playersService.ssoTicket(it.ssoTicket)?.let { dao ->
            when {
                dao.ssoTicket != it.ssoTicket -> null
                !playersService.editPlayer(dao.copy(ssoTicket = "")) -> null
                else -> SSOTicketProxyPacket(dao.id)
            }
        }
    }
)