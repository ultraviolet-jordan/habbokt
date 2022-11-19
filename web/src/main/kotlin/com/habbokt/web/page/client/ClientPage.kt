package com.habbokt.web.page.client

import com.habbokt.dao.players.PlayersDAO
import com.habbokt.dao.site.SiteService
import com.habbokt.web.common.decrypt
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import com.habbokt.web.session.UserSession
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import io.ktor.server.sessions.get
import java.util.UUID

/**
 * @author Jordan Abraham
 */
object ClientPage : Page {
    private val siteService by inject<SiteService>()
    private val playerDAO by inject<PlayersDAO>()

    override fun templateName(): String = "client.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mutableMapOf(
        "site" to siteService.site(),
        "forwardRoom" to false
    ).also {
        val session = sessions.get<UserSession>()!! // This call is authenticated by this session.

        val playerId = session.playerId.decrypt().toInt()
        val player = playerDAO.player(playerId) ?: throw Exception("Player not found with ID: $playerId") // Redirects back to "/".
        require(playerId == player.id)

        val ssoTicket = UUID.randomUUID().toString()
        // Edit player in DB with new ssoTicket when they launch client.
        if (playerDAO.editPlayer(player.copy(ssoTicket = ssoTicket))) {
            it["ssoTicket"] = ssoTicket // Update client with ssoTicket.
        }
    }
}