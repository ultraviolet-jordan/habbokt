package com.habbokt.packet.dasm.handshake.inforetrieve

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrieveProxyPacketHandler @Inject constructor(
    private val playersService: PlayersService
) : ProxyPacketHandler<InfoRetrievePacket, InfoRetrieveProxyPacket>(
    handler = {
        player()?.let {
            val dao = playersService.player(it.id) ?: return@let null
            InfoRetrieveProxyPacket(
                id = it.id.toString(),
                name = dao.name,
                figure = dao.figure,
                sex = dao.sex,
                motto = dao.motto
            )
        }
    }
)