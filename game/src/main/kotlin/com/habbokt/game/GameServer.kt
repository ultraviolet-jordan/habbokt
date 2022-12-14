package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.client.Client
import com.habbokt.api.server.Server
import io.ktor.network.sockets.ServerSocket
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.application.host
import io.ktor.server.application.port
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
@Singleton
class GameServer @Inject constructor(
    private val environment: ApplicationEnvironment,
    private val serverSocket: ServerSocket,
    private val serverConfiguration: ServerConfiguration
) : Server {
    val clients = ConcurrentHashMap<String, Client>() // This is weird

    override fun bind() = runBlocking {
        environment.log.info("Responding at ${environment.config.host}:${environment.config.port}...")
        while (true) {
            val socket = serverSocket.accept()
            val client = GameClient(
                environment = environment,
                socket = socket,
                gameServer = this@GameServer,
                assemblers = serverConfiguration.assemblers,
                disassemblers = serverConfiguration.disassemblers,
                handlers = serverConfiguration.handlers,
                proxies = serverConfiguration.proxies
            )
            environment.log.info("Connection from ${socket.remoteAddress}")
            // One client per connection only.
            clients[socket.remoteAddress.toString()] = client
            launch(Dispatchers.IO) { client.accept() }
        }
    }
}