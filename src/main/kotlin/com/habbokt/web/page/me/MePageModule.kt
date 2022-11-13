package com.habbokt.web.page.me

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun mePageModule(site: Site) = module(createdAtStart = true) {
    single { MePage(site) }
    single { MePageService(get(Compiler::class)) }
}
