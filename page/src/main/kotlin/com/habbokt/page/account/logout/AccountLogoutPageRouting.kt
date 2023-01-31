package com.habbokt.page.account.logout

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountLogoutPageRouting @Inject constructor(
    private val service: AccountLogoutPageService
) : PageRouting(
    routing = {
        authenticate(Authentications.User) {
            get("/account/logout") {
                service.handleGetRequest(call)
            }
        }
    }
)