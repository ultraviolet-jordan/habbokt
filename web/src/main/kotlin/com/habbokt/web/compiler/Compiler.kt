package com.habbokt.web.compiler

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.error.PebbleException
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
class Compiler(
    private val engine: PebbleEngine
) {
    fun compile(writer: StringWriter, templateName: String, context: Map<String, Any?>) {
        return try {
            // PebbleEngine can throw a PebbleException.
            engine.getTemplate(templateName).evaluate(writer, context)
        } catch (exception: PebbleException) {
            // Redirect to status pages.
            throw RuntimeException("PebbleEngine threw a PebbleException when evaluating the template: $templateName.", exception.cause)
        }
    }
}
