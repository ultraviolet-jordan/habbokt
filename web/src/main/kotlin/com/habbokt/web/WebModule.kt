package com.habbokt.web

import com.habbokt.db.DatabaseConfiguration
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.ApplicationEngine

/**
 * @author Jordan Abraham
 */
class WebModule(
    private val args: Array<String>
) : KotlinModule() {
    override fun configure() {
        bind<Array<String>>().toInstance(args)
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>()
        bind<ApplicationEngine>().toProvider<ApplicationEngineProvider>()
        bind<DatabaseConfiguration>().toProvider<DatabaseConfigurationProvider>()
    }
}