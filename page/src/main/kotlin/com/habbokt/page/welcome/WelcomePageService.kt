package com.habbokt.page.welcome

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class WelcomePageService @Inject constructor(
    page: WelcomePage,
    compiler: Compiler
) : PageService<WelcomePage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage()
    }
}