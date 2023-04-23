package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.argon2.Argon2Service
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.Html
import com.habbokt.page.PageService
import com.habbokt.page.Redirect
import com.habbokt.page.html
import com.habbokt.page.redirect
import com.habbokt.session.UserSession
import io.ktor.server.sessions.set
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPageService @Inject constructor(
    private val page: RegisterPage,
    private val playersService: PlayersService,
    private val argon2Service: Argon2Service
) : PageService<RegisterPageRequest, Html, Redirect>(
    get = {
        page.html(this)
    },

    post = {
        require(password != null)
        val passwordHash = argon2Service.hash(12, 65536, 1, password.toByteArray(StandardCharsets.UTF_8))
        require(passwordHash != null)
        require(session != null)
        require(username != null)
        require(email != null)
        require(appearance != null)
        require(gender != null)

        playersService.createPlayer(
            name = username,
            password = passwordHash,
            email = email,
            figure = appearance,
            sex = gender,
            ssoTicket = "",
            motto = ""
        )?.let {
            // Set a new authenticated user session.
            session.set(
                UserSession(
                    authenticated = true,
                    userId = it.id.toString()
                )
            )
            "/me".redirect() // TODO /welcome
        } ?: "/register".redirect()
    }
)