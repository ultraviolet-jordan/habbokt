package com.habbokt.web.plugin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.pebble.Pebble
import io.pebbletemplates.pebble.extension.AbstractExtension
import io.pebbletemplates.pebble.extension.Test
import io.pebbletemplates.pebble.loader.ClasspathLoader
import io.pebbletemplates.pebble.template.EvaluationContext
import io.pebbletemplates.pebble.template.EvaluationContextImpl
import io.pebbletemplates.pebble.template.PebbleTemplate
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
fun Application.installPebblePlugin() {
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix = "www-tpl/default-en"
            charset = StandardCharsets.UTF_8.toString()
            autoEscaping(false)
            strictVariables(false)
            extension(object : AbstractExtension(), Test {
                override fun getArgumentNames(): MutableList<String>? = null

                override fun apply(input: Any?, args: MutableMap<String, Any>?, self: PebbleTemplate?, context: EvaluationContext?, lineNumber: Int): Boolean {
                    require(input is String) { "PresentExtension only accepts a type string." }
                    return (context as EvaluationContextImpl).scopeChain.containsKey(input)
                }

                override fun getTests(): Map<String, Test> = mapOf("present" to this)
            })
        })
    }
}