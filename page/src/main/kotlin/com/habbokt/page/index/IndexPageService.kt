package com.habbokt.page.index

import com.google.inject.Inject
import com.habbokt.page.Page
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
class IndexPageService<P : Page<*>> @Inject constructor(
    compiler: Compiler,
    private val page: P
) : PageService<P>(compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage(page)
    }
}