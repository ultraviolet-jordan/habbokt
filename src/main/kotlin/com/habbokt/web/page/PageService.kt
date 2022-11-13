package com.habbokt.web.page

import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
interface PageService<P : Page> {
    suspend fun respondPage(call: ApplicationCall, page: P)
}
