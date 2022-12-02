package com.habbokt.game

import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationEnvironment

/**
 * @author Jordan Abraham
 */
class GameModule(
    private val application: Application
) : KotlinModule() {
    override fun configure() {
        bind<ServerSocket>().toProvider<ServerSocketProvider>()
        bind<Application>().toInstance(application)
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>()
    }
}