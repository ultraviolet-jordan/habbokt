package com.habbokt.game

import com.habbokt.db.DatabaseConfiguration
import com.habbokt.db.DatabaseModule
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
class GameModule(
    private val applicationEngine: NettyApplicationEngine,
    private val databaseConfiguration: DatabaseConfiguration
) : KotlinModule() {
    override fun configure() {
        install(DatabaseModule(databaseConfiguration))

        bind<NettyApplicationEngine>().toInstance(applicationEngine)
        bind<SelectorManager>().toProvider<ServerSocketSelectorProvider>()
        bind<ServerSocket>().toProvider<ServerSocketProvider>()
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>()
        bind<ForkJoinPool>().toProvider<ForkJoinPoolProvider>()
    }
}