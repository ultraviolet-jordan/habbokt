package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.network.sockets.aSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.application.host
import io.ktor.server.application.port

/**
 * @author Jordan Abraham
 */
@Singleton
class ServerSocketProvider @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment,
    private val selectorManager: SelectorManager
) : Provider<ServerSocket> {
    override fun get(): ServerSocket = aSocket(selectorManager).tcp().bind(applicationEnvironment.config.host, applicationEnvironment.config.port) {
        reuseAddress = true
    }
}