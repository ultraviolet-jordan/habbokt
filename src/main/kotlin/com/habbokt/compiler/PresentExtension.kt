package com.habbokt.compiler

import com.mitchellbosecke.pebble.extension.AbstractExtension
import com.mitchellbosecke.pebble.extension.Test
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.EvaluationContextImpl
import com.mitchellbosecke.pebble.template.PebbleTemplate
import java.util.Map

/**
 * @author Jordan Abraham
 */
class PresentExtension : AbstractExtension(), Test {
    override fun getArgumentNames(): MutableList<String>? = null

    override fun apply(input: Any, args: MutableMap<String, Any>, self: PebbleTemplate, context: EvaluationContext, lineNumber: Int): Boolean {
        require(input is String) { "PresentExtension only accepts a type string." }
        return (context as EvaluationContextImpl).scopeChain.containsKey(input)
    }

    override fun getTests(): MutableMap<String, Test> = Map.of("present", this)
}
