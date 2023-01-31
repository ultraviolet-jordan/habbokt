package com.habbokt.page

import io.ktor.server.request.ApplicationRequest
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
abstract class Page<T : PageTemplate>(
    private val template: suspend (CurrentSession, ApplicationRequest) -> T
) {
    suspend fun template(
        currentSession: CurrentSession,
        request: ApplicationRequest
    ): T = template.invoke(currentSession, request).also { it.configuration.invoke(it) }
}