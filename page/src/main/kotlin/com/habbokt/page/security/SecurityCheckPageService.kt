package com.habbokt.page.security

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class SecurityCheckPageService @Inject constructor(
    page: SecurityCheckPage,
    compiler: Compiler
) : PageService<SecurityCheckPage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage()
    }
}