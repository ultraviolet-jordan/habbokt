package com.habbokt.game

import com.habbokt.api.packet.ClientHelloPacket
import com.habbokt.api.plugin.PacketAssemblerPluginKey
import com.habbokt.api.plugin.PacketDisassemblerPluginKey
import com.habbokt.api.plugin.PacketHandlerPluginKey
import com.habbokt.dao.DatabaseFactory
import com.habbokt.game.plugin.installKoinPlugin
import com.habbokt.game.plugin.installPacketAssemblerPlugin
import com.habbokt.game.plugin.installPacketDisassemblerPlugin
import com.habbokt.game.plugin.installPacketHandlerPlugin
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.Application
import io.ktor.server.application.log
import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val selector = ActorSelectorManager(dispatcher)

fun Application.module() {
    // Load DatabaseFactory.
    DatabaseFactory.init(
        driverClassName = environment.config.property("storage.driverClassName").getString(),
        jdbcUrl = environment.config.property("storage.jdbcURL").getString(),
        useConsole = environment.config.property("h2.console.enabled").getString().toBoolean()
    )

    installKoinPlugin()
    installPacketAssemblerPlugin()
    installPacketDisassemblerPlugin()
    installPacketHandlerPlugin()

    val hostname = "127.0.0.1"
    val port = 43594

    runBlocking {
        val server = aSocket(selector).tcp().bind(hostname, port) {
            backlogSize = 1000
            reuseAddress = true
        }

        log.info("Responding at http://$hostname:$port")

        while (true) {
            val socket = server.accept()

            launch(Dispatchers.IO) {
                val client = GameClient(
                    readChannel = socket.openReadChannel(),
                    writeChannel = socket.openWriteChannel(),
                    assemblers = attributes[PacketAssemblerPluginKey],
                    disassemblers = attributes[PacketDisassemblerPluginKey],
                    handlers = attributes[PacketHandlerPluginKey]
                )

                client.writePacket(ClientHelloPacket())

                try {
                    while (true) {
                        val readPacket = client.awaitPacket() ?: continue
                        client.handlePacket(readPacket)
                    }
                } catch (exception: Exception) {
                    log.error("Exception caught by connected client. Disconnecting...", exception)
                    socket.close()
                }
            }
        }
    }
}