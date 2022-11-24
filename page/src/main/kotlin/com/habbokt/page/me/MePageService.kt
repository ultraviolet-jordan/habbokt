package com.habbokt.page.me

import com.google.inject.Inject
import com.habbokt.page.Page
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
class MePageService<P : Page<*>> @Inject constructor(
    compiler: Compiler,
    private val page: P
) : PageService<P>(compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage(page)
    }
}