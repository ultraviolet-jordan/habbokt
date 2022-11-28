package com.habbokt.templating

import dev.misfitlabs.kotlinguice4.KotlinModule
import io.pebbletemplates.pebble.PebbleEngine
import java.io.File
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
object TemplatingModule : KotlinModule() {
    override fun configure() {
        val engine = PebbleEngine.Builder()
            .strictVariables(false)
            .autoEscaping(false)
            .extension(PresentExtension())
            .build()
            .also {
                it.loader.setCharset(StandardCharsets.UTF_8.toString())
                it.loader.setPrefix(File(object{}::class.java.classLoader.getResource("www-tpl/default-en")!!.toURI()).absolutePath)
            }
        bind<PebbleEngine>().toInstance(engine)
    }
}