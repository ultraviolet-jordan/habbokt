package com.habbokt.packet.dasm.handshake.inforetrieve

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.players.PlayersService

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrieveProxyPacketHandler @Inject constructor(
    private val playersService: PlayersService
) : ProxyPacketHandler<InfoRetrievePacket>(ProxyHandler {
    val player = it.player() ?: return@ProxyHandler null
    val (id, name, _, _, figure, sex, _, motto) = playersService.player(player.id) ?: return@ProxyHandler null
    return@ProxyHandler InfoRetrieveProxyPacket(
        id = id.toString(),
        name = name,
        figure = figure,
        sex = sex,
        motto = motto
    )
})