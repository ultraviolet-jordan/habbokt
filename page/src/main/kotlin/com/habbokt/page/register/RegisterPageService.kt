package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPageService @Inject constructor(
    page: RegisterPage,
    compiler: Compiler
) : PageService<RegisterPage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.respondHtmlPage()
    }
}