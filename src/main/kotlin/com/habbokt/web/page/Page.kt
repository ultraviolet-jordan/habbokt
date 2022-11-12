package com.habbokt.web.page

import com.habbokt.web.compiler.Compiler
import io.ktor.http.Parameters
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
