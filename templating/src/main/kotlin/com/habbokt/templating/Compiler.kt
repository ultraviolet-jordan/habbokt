package com.habbokt.templating

import com.google.inject.Inject
import com.google.inject.Singleton
import io.pebbletemplates.pebble.PebbleEngine
import io.pebbletemplates.pebble.error.PebbleException
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
@Singleton
class Compiler @Inject constructor(
    private val engine: PebbleEngine
) {
    fun compile(templateName: String, context: Map<String, Any?>): String {
        return try {
            StringWriter().apply {
                // PebbleEngine can throw a PebbleException.
                engine.getTemplate(templateName).evaluate(this, context)
            }.toString()
        } catch (exception: PebbleException) {
            // Redirect to status pages.
            throw RuntimeException("PebbleEngine threw a PebbleException when evaluating the template: $templateName.", exception.cause)
        }
    }
}
