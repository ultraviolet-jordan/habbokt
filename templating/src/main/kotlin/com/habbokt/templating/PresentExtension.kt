package com.habbokt.templating

import io.pebbletemplates.pebble.extension.AbstractExtension
import io.pebbletemplates.pebble.extension.Test
import io.pebbletemplates.pebble.template.EvaluationContext
import io.pebbletemplates.pebble.template.EvaluationContextImpl
import io.pebbletemplates.pebble.template.PebbleTemplate

/**
 * @author Jordan Abraham
 */
class PresentExtension : AbstractExtension(), Test {
    override fun getArgumentNames(): MutableList<String>? = null

    override fun apply(input: Any, args: MutableMap<String, Any>, self: PebbleTemplate, context: EvaluationContext, lineNumber: Int): Boolean {
        require(input is String) { "PresentExtension only accepts a type string." }
        return (context as EvaluationContextImpl).scopeChain.containsKey(input)
    }

    override fun getTests(): MutableMap<String, Test> = mutableMapOf("present" to this)
}
