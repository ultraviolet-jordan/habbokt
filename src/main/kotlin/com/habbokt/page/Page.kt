package com.habbokt.page

import com.habbokt.compiler.Compiler
import io.ktor.http.Parameters
import java.io.StringWriter
import java.lang.Exception

/**
 * @author Jordan Abraham
 */
interface Page {
    fun templateName(): String
    fun context(parameters: Parameters): Map<String, Any?>

    fun html(queryParameters: Parameters, compiler: Compiler): String = StringWriter().apply {
        try {
            // PebbleEngine can throw an internal exception when translating.
            compiler.compile(this, templateName(), context(queryParameters))
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }.toString()
}
