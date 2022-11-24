package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installCallLoggingPlugin
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
    ).findBindingsByType<PageRouting>()
        .map { it.provider.get().route() }
        .forEach { it.block.invoke(this@module.routing{}) }

    installCallLoggingPlugin()
    installSessionsPlugin()
}