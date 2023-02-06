package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.argon2.Argon2Service
import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.None
import com.habbokt.page.PageService
import com.habbokt.page.Redirect
import com.habbokt.page.redirect
import com.habbokt.session.UserSession
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountSubmitPageService @Inject constructor(
    private val playersService: PlayersService,
    private val argon2Service: Argon2Service
) : PageService<AccountSubmitPageRequest, None, Redirect>(
    post = {
        playersService.validatePlayer(argon2Service, username, password)?.let {
            if (session.get<UserSession>() != null) {
                session.clear<UserSession>()
            }
            // Set a new authenticated user session.
            session.set(
                UserSession(
                    authenticated = true,
                    userId = it.id.toString()
                )
            )
            "/security_check".redirect()
        } ?: "/?page=submit&username=$username&rememberme=$rememberMe".redirect()
    }
)

private suspend fun PlayersService.validatePlayer(
    argon2Service: Argon2Service,
    username: String,
    password: String
): PlayerDAO? {
    val playerId = getId(username) ?: return null
    val player = player(playerId) ?: return null
    if (!argon2Service.verify(player.password, password.toByteArray())) return null
    return player
}