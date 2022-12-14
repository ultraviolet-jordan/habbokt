package com.habbokt.game

import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationEnvironment
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
class GameModule(
    private val application: Application
) : KotlinModule() {
    override fun configure() {
        bind<Application>().toInstance(application)

        bind<ServerSocket>().toProvider<ServerSocketProvider>()
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>()
        bind<ForkJoinPool>().toProvider<ForkJoinPoolProvider>()
    }
}