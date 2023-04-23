package com.habbokt.page.client

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.session.UserSession
import java.util.UUID

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientPage @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService
) : Page<ClientPageRequest>(
    name = "client.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }

        put("forwardRoom", false)

        playersService.ssoTicket(it.userSession)?.let { ssoTicket ->
            put("ssoTicket", ssoTicket)
        }
    }
)

private suspend fun PlayersService.ssoTicket(userSession: UserSession): String? {
    val playerId = userSession.userId.toInt()
    val player = player(playerId) ?: throw Exception("Player not found with ID: $playerId") // Redirects back to "/".
    require(playerId == player.id) // Redirects back to "/".
    val ssoTicket = UUID.randomUUID().toString()
    return if (editPlayer(player.copy(ssoTicket = ssoTicket))) ssoTicket else null
}
