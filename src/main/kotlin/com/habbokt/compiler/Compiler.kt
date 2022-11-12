package com.habbokt.compiler

import com.mitchellbosecke.pebble.PebbleEngine
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
class Compiler(
    private val engine: PebbleEngine
) {
    fun compile(writer: StringWriter, templateName: String, context: Map<String, Any?>) {
        return engine.getTemplate(templateName).evaluate(writer, context)
    }
}