package com.habbokt.page

import com.google.inject.Singleton
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
@Singleton
class BlankPage : Page<BlankTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<BlankTemplate> = Template { BlankTemplate }
}