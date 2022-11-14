package com.habbokt.web.plugin.koin.index

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.index.IndexPage
import com.habbokt.web.page.index.IndexPageService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun indexPageModule() = module(createdAtStart = true) {
    single { IndexPage() }
    single { IndexPageService(get(Compiler::class)) }
}
