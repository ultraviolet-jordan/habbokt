package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.network.sockets.aSocket
import io.ktor.server.application.host
import io.ktor.server.application.port
import io.ktor.server.netty.NettyApplicationEngine

/**
 * @author Jordan Abraham
 */
@Singleton
class ServerSocketProvider @Inject constructor(
    private val applicationEngine: NettyApplicationEngine,
    private val selectorManager: SelectorManager
) : Provider<ServerSocket> {
    override fun get(): ServerSocket = aSocket(selectorManager).tcp().bind(applicationEngine.environment.config.host, applicationEngine.environment.config.port) {
        reuseAddress = true
    }
}