package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.argon2.Argon2Service
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.PageService
import com.habbokt.session.UserSession
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
    private val playersService: PlayersService,
    private val argon2Service: Argon2Service
) : PageService<AccountSubmitPage>(
    post = response@{
        val parameters = receiveParameters()
        val username = parameters["username"]
        val password = parameters["password"]
        val rememberMe = parameters["_login_remember_me"].toBoolean()

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            return@response respondRedirect("/") // Homepage
        }

        val redirectUrl = "/?page=submit&username=$username&rememberme=$rememberMe"

        val playerId = playersService.getId(username) ?: return@response respondRedirect(redirectUrl)

        val player = playersService.player(playerId) ?: return@response respondRedirect(redirectUrl)

        if (!argon2Service.verify(player.password, password.toByteArray())) {
            return@response respondRedirect(redirectUrl)
        }

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

        return@response respondRedirect("/security_check")
    }
)