package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installSessionsPlugin
import dev.misfitlabs.kotlinguice4.findBindingsByType
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.module() {
    Guice.createInjector(
        PageModule(this)
    ).findBindingsByType<PageRouting>().forEach {
        it.provider.get().configure()
    }

    installSessionsPlugin()
}