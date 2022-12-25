package com.habbokt.game

import com.habbokt.db.DatabaseConfiguration
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.ApplicationEngine
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
class GameModule(
    private val args: Array<String>
) : KotlinModule() {
    override fun configure() {
        bind<Array<String>>().toInstance(args)
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>()
        bind<ApplicationEngine>().toProvider<ApplicationEngineProvider>()
        bind<DatabaseConfiguration>().toProvider<DatabaseConfigurationProvider>()
        bind<SelectorManager>().toProvider<ServerSocketSelectorProvider>()
        bind<ServerSocket>().toProvider<ServerSocketProvider>()
        bind<ForkJoinPool>().toProvider<ForkJoinPoolProvider>()
    }
}