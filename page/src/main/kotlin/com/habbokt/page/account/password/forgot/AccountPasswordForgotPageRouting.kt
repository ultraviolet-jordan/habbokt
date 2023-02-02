package com.habbokt.page.account.password.forgot

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountPasswordForgotPageRouting @Inject constructor(
    private val service: AccountPasswordForgotPageService
) : PageRouting(
    routing = {
        get("/account/password/forgot") {
            call.respondHtml(HttpStatusCode.OK, service.getRequest(AccountPasswordForgotPageRequest.Empty))
        }
    }
)