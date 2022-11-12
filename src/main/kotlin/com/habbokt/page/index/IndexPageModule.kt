package com.habbokt.page.index

import com.habbokt.compiler.Compiler
import com.habbokt.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun indexPageModule(site: Site) = module(createdAtStart = true) {
    single { IndexPage(site) }
    single { IndexPageService(get(Compiler::class)) }
}