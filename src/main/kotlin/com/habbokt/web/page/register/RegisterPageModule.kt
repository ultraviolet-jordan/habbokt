package com.habbokt.web.page.register

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun registerPageModule(site: Site) = module(createdAtStart = true) {
    single { RegisterPage(site) }
    single { RegisterPageService(get(Compiler::class)) }
}
