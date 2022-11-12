package com.habbokt.page

import com.habbokt.compiler.Compiler
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header
import io.ktor.server.response.respond
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
interface Page {
    fun templateName(): String
    fun context(parameters: Parameters): Map<String, Any?>

    fun html(queryParameters: Parameters, compiler: Compiler): String = StringWriter().apply {
        compiler.compile(this, templateName(), context(queryParameters))
    }.toString()
}