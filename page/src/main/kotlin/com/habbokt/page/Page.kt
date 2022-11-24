package com.habbokt.page

import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
interface Page<T : BaseTemplate> {
    suspend fun template(sessions: CurrentSession, parameters: Parameters): T
}