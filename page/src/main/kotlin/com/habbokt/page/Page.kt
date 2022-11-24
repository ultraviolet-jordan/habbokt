package com.habbokt.page

import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
interface Page<out T : BaseTemplate> {
    /**
     * Generates the necessary template to be interpreted when the page loads.
     */
    suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<T>
}