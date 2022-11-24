package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installSessionsPlugin
import dev.misfitlabs.kotlinguice4.findBindingsByType
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.module() {
    Guice.createInjector(
        PageModule
    ).findBindingsByType<PageRouting>().forEach {
        it.provider.get().route().block.invoke(this@module.routing {})
    }

    installSessionsPlugin()
}