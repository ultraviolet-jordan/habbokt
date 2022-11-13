package com.habbokt.web.page

import com.habbokt.web.compiler.Compiler
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
interface Page {
    fun templateName(): String
    fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?>

    fun html(session: CurrentSession, queryParameters: Parameters, compiler: Compiler): String = StringWriter().apply {
        compiler.compile(this, templateName(), context(session, queryParameters))
    }.toString()
}
