package com.habbokt.web.page

import com.habbokt.templating.Compiler
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
interface Page {
    fun templateName(): String
    suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?>

    suspend fun html(session: CurrentSession, queryParameters: Parameters): String = StringWriter().apply {
        com.habbokt.api.inject<Compiler>().value.compile(this, templateName(), context(session, queryParameters))
    }.toString()
}
