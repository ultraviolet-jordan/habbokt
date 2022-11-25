package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRoute
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.routing.post

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountSubmitPageRouting @Inject constructor(
    private val service: AccountSubmitPageService
) : PageRouting {
    override fun route(): PageRoute = PageRoute {
        post("/account/submit") {
            service.handlePostRequest(call)
        }
    }
}