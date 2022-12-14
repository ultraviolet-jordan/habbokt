package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.server.Server
import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.application.host
import io.ktor.server.application.port
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
@Singleton
class GameServer @Inject constructor(
    private val serverSocket: ServerSocket,
    private val selectorManager: SelectorManager,
    private val serverConfiguration: ServerConfiguration,
    private val connectionPool: ConnectionPool,
    private val applicationEnvironment: ApplicationEnvironment
) : Server {
    override fun bind() = runBlocking {
        applicationEnvironment.log.info("Responding at ${applicationEnvironment.config.host}:${applicationEnvironment.config.port}...")
        while (connectionPool.accepting()) {
            val socket = serverSocket.accept()
            val client = GameClient(
                applicationEnvironment = applicationEnvironment,
                socket = socket,
                connectionPool = connectionPool,
                assemblers = serverConfiguration.assemblers,
                disassemblers = serverConfiguration.disassemblers,
                handlers = serverConfiguration.handlers,
                proxies = serverConfiguration.proxies
            )
            if (connectionPool.add(client)) {
                applicationEnvironment.log.info("Connection from ${socket.remoteAddress}")
                launch(Dispatchers.IO) { client.accept() }
            }
        }
    }

    override fun close() {
        connectionPool.dropAll().clear()
        selectorManager.close()
    }
}
