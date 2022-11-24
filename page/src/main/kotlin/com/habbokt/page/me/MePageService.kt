package com.habbokt.page.me

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Page
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class MePageService<P : Page<*>> @Inject constructor(
    page: P,
    compiler: Compiler
) : PageService<P>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage()
    }
}