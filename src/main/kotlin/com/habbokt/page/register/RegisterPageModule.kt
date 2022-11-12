package com.habbokt.page.register

import com.habbokt.compiler.Compiler
import com.habbokt.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun registerPageModule(site: Site) = module(createdAtStart = true) {
    single { RegisterPage(site) }
    single { RegisterPageService(get(Compiler::class)) }
}
