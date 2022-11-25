package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.db.DatabaseResourceBuilder
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import dev.misfitlabs.kotlinguice4.findBindingsByType
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.web() {
    // Database
    DatabaseResourceBuilder.connect {
        driverClassName = environment.config.property("storage.driverClassName").getString()
        jdbcUrl = environment.config.property("storage.jdbcUrl").getString()
        enableConsole = environment.config.property("storage.consoleEnabled").getString().toBoolean()
        maximumPoolSize = 2
    }

    // Ktor Plugins
    installCallLoggingPlugin()
    installSessionsPlugin()
    installAuthenticationPlugin()
    installStatusPagesPlugin()

    // Guice Injector
    Guice.createInjector(
        PageModule
    ).findBindingsByType<PageRouting>()
        .map { it.provider.get().route() }
        .forEach { it.block.invoke(this@web.routing{}) }
}