package com.habbokt.web.plugin.koin.me

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.me.MePage
import com.habbokt.web.page.me.MePageService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun mePageModule() = module(createdAtStart = true) {
    single { MePage() }
    single { MePageService(get(Compiler::class)) }
}
