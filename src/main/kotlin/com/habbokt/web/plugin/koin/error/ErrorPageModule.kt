package com.habbokt.web.plugin.koin.error

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.error.ErrorPage
import com.habbokt.web.page.error.ErrorPageService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun errorPageModule() = module(createdAtStart = true) {
    single { ErrorPage() }
    single { ErrorPageService(get(Compiler::class)) }
}
