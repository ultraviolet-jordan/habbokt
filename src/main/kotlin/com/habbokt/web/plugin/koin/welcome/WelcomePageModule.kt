package com.habbokt.web.plugin.koin.welcome

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.welcome.WelcomePage
import com.habbokt.web.page.welcome.WelcomePageService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun welcomePageModule() = module(createdAtStart = true) {
    single { WelcomePage() }
    single { WelcomePageService(get(Compiler::class)) }
}
