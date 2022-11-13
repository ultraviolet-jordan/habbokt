package com.habbokt.web.page.welcome

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.model.Site
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun welcomePageModule(site: Site) = module(createdAtStart = true) {
    single { WelcomePage(site) }
    single { WelcomePageService(get(Compiler::class)) }
}
