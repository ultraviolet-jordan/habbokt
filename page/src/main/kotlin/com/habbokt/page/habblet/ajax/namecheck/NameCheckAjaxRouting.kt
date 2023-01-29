package com.habbokt.page.habblet.ajax.namecheck

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.routing.post

/**
 * @author Jordan Abraham
 */
@Singleton
class NameCheckAjaxRouting @Inject constructor(
    private val service: NameCheckAjaxService
) : PageRouting(
    routing = {
        post("/habblet/ajax/namecheck") {
            service.handlePostRequest(call)
        }
    }
)