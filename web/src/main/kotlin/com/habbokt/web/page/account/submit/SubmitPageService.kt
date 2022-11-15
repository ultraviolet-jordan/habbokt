package com.habbokt.web.page.account.submit

import com.habbokt.dao.players.PlayersDAO
import com.habbokt.web.common.encrypt
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import com.habbokt.web.page.PageService
import com.habbokt.web.session.UserSession
import de.mkammerer.argon2.Argon2
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
object SubmitPageService : PageService {
    private val dao by inject<PlayersDAO>()
    private val argon2 by inject<Argon2>()

    override suspend fun respondPage(call: ApplicationCall, page: Page) {
        val parameters = call.receiveParameters()
        val username = parameters["username"]
        val password = parameters["password"]
        val rememberMe = parameters["_login_remember_me"].toBoolean()

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondRedirect("/") // Homepage
            return
        }

        val redirectUrl = "/?page=submit&username=$username&rememberme=$rememberMe"

        val playerId = dao.getId(username)
        if (playerId == null) {
            call.respondRedirect(redirectUrl)
            return
        }

        val player = dao.player(playerId)
        if (player == null) {
            call.respondRedirect(redirectUrl)
            return
        }

        if (!argon2.verify(player.password, password.toByteArray())) {
            call.respondRedirect(redirectUrl)
            return
        }

        val sessions = call.sessions
        if (sessions.get<UserSession>() != null) {
            sessions.clear<UserSession>()
        }

        // Set a new authenticated user session.
        sessions.set(
            UserSession(
                authenticated = true,
                id = player.id.toString().encrypt()
            )
        )
        call.respondRedirect("/security_check")
    }
}