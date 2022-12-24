package com.habbokt.web

import com.google.inject.Guice
import com.habbokt.db.DatabaseConfiguration
import com.habbokt.db.HikariDatabase
import com.habbokt.page.PageModule
import com.habbokt.page.PageRouting
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import dev.misfitlabs.kotlinguice4.findBindingsByType
import dev.misfitlabs.kotlinguice4.getInstance
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.loadCommonConfiguration
import io.ktor.server.netty.NettyApplicationEngine
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>) {
    val applicationEnvironment = commandLineEnvironment(args)
    val applicationEngine = NettyApplicationEngine(applicationEnvironment) { loadCommonConfiguration(applicationEnvironment.config) }

    val databaseConfiguration = DatabaseConfiguration(
        driverClassName = applicationEnvironment.config.property("storage.driverClassName").getString(),
        jdbcUrl = applicationEnvironment.config.property("storage.jdbcUrl").getString(),
        maximumPoolSize = 2,
        isAutoCommit = true,
        transactionIsolation = "TRANSACTION_REPEATABLE_READ",
        enableConsole = applicationEnvironment.config.property("storage.consoleEnabled").getString().toBoolean()
    )

    with(applicationEngine.application) {
        installCallLoggingPlugin()
        installSessionsPlugin()
        installAuthenticationPlugin()
        installStatusPagesPlugin()
    }

    val injector = Guice.createInjector(
        WebModule(databaseConfiguration),
        PageModule
    )

    val database = injector.getInstance<HikariDatabase>()

    Runtime.getRuntime().addShutdownHook(ShutdownHook(applicationEngine, database))

    // This is temporary for now the web server handles creating the db.
    database.connect()
    database.createTables()

    injector.findBindingsByType<PageRouting>()
        .map { it.provider.get().route.block }
        .forEach { it.invoke(applicationEngine.application.routing {}) }

    applicationEngine.start(wait = true)
}