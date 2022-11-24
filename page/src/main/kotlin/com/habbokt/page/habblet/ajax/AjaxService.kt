package com.habbokt.page.habblet.ajax.namecheck

import com.habbokt.page.Page
import com.habbokt.page.PageService
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
abstract class AjaxService<P : Page<*>> constructor(
    page: P
) : PageService<P>(page, null) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        println("Ajax")
    }
}