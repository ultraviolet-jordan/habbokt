package com.habbokt.page.client

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.page.Template
import com.habbokt.session.UserSession
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import io.ktor.server.sessions.get
import java.util.UUID

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientPage @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService
) : Page<ClientPageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<ClientPageTemplate> = Template {
        val session = sessions.get<UserSession>()!! // This call is authenticated by this session.

        ClientPageTemplate(
            site = siteService.site(),
            forwardRoom = false,
            ssoTicket = ssoTicket(session)
        )
    }

    private suspend fun ssoTicket(session: UserSession): String? {
        val playerId = session.userId.toInt()
        val player = playersService.player(playerId) ?: throw Exception("Player not found with ID: $playerId") // Redirects back to "/".
        require(playerId == player.id) // Redirects back to "/".
        val ssoTicket = UUID.randomUUID().toString()
        return if (playersService.editPlayer(player.copy(ssoTicket = ssoTicket))) ssoTicket else null
    }
}