package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.network.sockets.aSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.application.host
import io.ktor.server.application.port
import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher

/**
 * @author Jordan Abraham
 */
@Singleton
class ServerSocketProvider @Inject constructor(
    private val environment: ApplicationEnvironment
) : Provider<ServerSocket> {
    override fun get(): ServerSocket = aSocket(SelectorManager(Executors.newCachedThreadPool().asCoroutineDispatcher())).tcp().bind(environment.config.host, environment.config.port) {
        reuseAddress = true
    }
}