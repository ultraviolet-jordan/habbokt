package com.habbokt.web.page.index

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun indexPageModule(site: Site) = module(createdAtStart = true) {
    single { IndexPage(site) }
    single { IndexPageService(get(Compiler::class)) }
}
