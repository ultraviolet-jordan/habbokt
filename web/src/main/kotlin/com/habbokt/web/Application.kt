package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.db.DatabaseModule
import com.habbokt.db.HikariDatabase
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installPebblePlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import dev.misfitlabs.kotlinguice4.findBindingsByType
import dev.misfitlabs.kotlinguice4.getInstance
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>) {
    try {
        val injector = Guice.createInjector(
            WebModule(args),
            PageModule
        )

        val database = Guice.createInjector(DatabaseModule(injector.getInstance())).getInstance<HikariDatabase>()
        val applicationEnvironment = injector.getInstance<ApplicationEnvironment>()
        val applicationEngine = injector.getInstance<ApplicationEngine>()

        with(applicationEngine.application) {
            installCallLoggingPlugin()
            installSessionsPlugin()
            installAuthenticationPlugin()
            installStatusPagesPlugin()
            installPebblePlugin()
        }

        Runtime.getRuntime().addShutdownHook(ShutdownHook(applicationEnvironment.log, applicationEngine, database))

        // This is temporary for now the web server handles creating the db.
        database.connect()
        database.createTables()

        injector.findBindingsByType<PageRouting>()
            .map { it.provider.get().routing }
            .forEach { it.invoke(applicationEngine.application.routing {}) }

        applicationEngine.start(wait = true)
    } catch (exception: Exception) {
        exception.printStackTrace()
    }
}