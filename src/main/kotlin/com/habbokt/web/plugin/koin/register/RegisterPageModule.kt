package com.habbokt.web.plugin.koin.register

import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.register.RegisterPage
import com.habbokt.web.page.register.RegisterPageService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun registerPageModule() = module(createdAtStart = true) {
    single { RegisterPage() }
    single { RegisterPageService(get(Compiler::class)) }
}
