package com.habbokt.templating

import com.mitchellbosecke.pebble.PebbleEngine
import java.io.File
import java.nio.charset.StandardCharsets
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
val CompilerModule = module(createdAtStart = true) {
    single {
        Compiler(
            PebbleEngine.Builder()
                .strictVariables(false)
                .autoEscaping(false)
                .extension(PresentExtension())
                .build()
                .also {
                    it.loader.setCharset(StandardCharsets.UTF_8.toString())
                    it.loader.setPrefix(File(object{}::class.java.classLoader.getResource("www-tpl/default-en")!!.toURI()).absolutePath)
                }
        )
    }
}
