package com.habbokt.page.index

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
class IndexPageService @Inject constructor(
    page: IndexPage,
    compiler: Compiler
) : PageService<IndexPage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage()
    }
}