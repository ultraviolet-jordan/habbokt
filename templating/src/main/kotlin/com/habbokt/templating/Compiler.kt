package com.habbokt.templating

import com.google.inject.Inject
import com.google.inject.Singleton
import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.error.PebbleException
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
@Singleton
class Compiler @Inject constructor(
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
