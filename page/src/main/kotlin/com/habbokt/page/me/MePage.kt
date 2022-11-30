package com.habbokt.page.me

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

/**
 * @author Jordan Abraham
 */
@Singleton
class MePage @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService
) : Page<MePageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<MePageTemplate> = Template {
        val session = sessions.get<UserSession>()!! // This call is authenticated by this session.


        MePageTemplate(
            site = siteService.site(),
            playerDetails = playersService.player(session.userId.toInt())
        )
    }
}