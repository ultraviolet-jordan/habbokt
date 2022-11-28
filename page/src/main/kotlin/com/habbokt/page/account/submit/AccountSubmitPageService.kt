package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.argon2.Argon2Service
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.PageService
import com.habbokt.session.UserSession
import com.habbokt.templating.Compiler
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
@Singleton
class AccountSubmitPageService @Inject constructor(
    page: AccountSubmitPage,
    compiler: Compiler,
    private val playersService: PlayersService,
    private val argon2Service: Argon2Service
) : PageService<AccountSubmitPage>(page, compiler) {
    override suspend fun handlePostRequest(call: ApplicationCall) {
        val parameters = call.receiveParameters()
        val username = parameters["username"]
        val password = parameters["password"]
        val rememberMe = parameters["_login_remember_me"].toBoolean()

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            call.respondRedirect("/") // Homepage
            return
        }

        val redirectUrl = "/?page=submit&username=$username&rememberme=$rememberMe"

        val playerId = playersService.getId(username)
        if (playerId == null) {
            call.respondRedirect(redirectUrl)
            return
        }

        val player = playersService.player(playerId)
        if (player == null) {
            call.respondRedirect(redirectUrl)
            return
        }

        if (!argon2Service.verify(player.password, password.toByteArray())) {
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
                userId = player.id.toString()
            )
        )
        call.respondRedirect("/security_check")
    }
}