package com.habbokt.compiler

import com.mitchellbosecke.pebble.PebbleEngine
import org.koin.dsl.module
import java.io.File
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
fun compilerModule() = module(createdAtStart = true) {
    single {
        Compiler(
            PebbleEngine.Builder()
                .strictVariables(false)
                .autoEscaping(false)
                .extension(PresentExtension())
                .build()
                .also {
                    it.loader.setCharset(StandardCharsets.UTF_8.toString())
                    it.loader.setPrefix(File(this::class.java.classLoader.getResource("www-tpl/default-en")!!.toURI()).absolutePath)
                }
        )
    }
}
