package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.respondRedirect
import io.ktor.server.application.call
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.post
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountSubmitPageRouting @Inject constructor(
    private val service: AccountSubmitPageService
) : PageRouting(
    routing = {
        post("/account/submit") {
            val parameters = call.receiveParameters()
            val username = parameters["username"]
            val password = parameters["password"]
            val rememberMe = parameters["_login_remember_me"].toBoolean()

            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                return@post call.respondRedirect("/")
            }

            val request = AccountSubmitPageRequest(
                session = call.sessions,
                username = username,
                password = password,
                rememberMe = rememberMe
            )

            call.respondRedirect(service.postRequest(request))
        }
    }
)