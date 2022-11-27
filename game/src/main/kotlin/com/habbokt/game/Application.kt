package com.habbokt.game

import com.google.inject.Guice
import com.habbokt.api.packet.Packet
import com.habbokt.db.DatabaseResourceBuilder
import com.habbokt.packet.ClientHelloPacket
import com.habbokt.packet.PacketModule
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.dasm.DisassemblerListener
import com.habbokt.packet.handler.HandlerListener
import dev.misfitlabs.kotlinguice4.findBindingsByType
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.server.application.port
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

fun Application.game() {
    // Database
    DatabaseResourceBuilder.connect {
        driverClassName = environment.config.property("storage.driverClassName").getString()
        jdbcUrl = environment.config.property("storage.jdbcUrl").getString()
        maximumPoolSize = 2
    }

    // Guice
    val injector = Guice.createInjector(
        PacketModule
    )

    val assemblers = injector.findBindingsByType<AssemblerListener<*>>().map { it.provider.get() } as List<AssemblerListener<Packet>>
    val disassemblers = injector.findBindingsByType<DisassemblerListener>().map { it.provider.get() }
    val handlers = injector.findBindingsByType<HandlerListener<*>>().map { it.provider.get() } as List<HandlerListener<Packet>>

    runBlocking {
        val server = aSocket(selector).tcp().bind("127.0.0.1", environment.config.port) {
            reuseAddress = true
        }

        log.info("Responding at http://127.0.0.1:${environment.config.port}")

        while (true) {
            val socket = server.accept()

            launch(Dispatchers.IO) {
                log.info("Connection from ${socket.remoteAddress}")

                val client = GameClient(
                    readChannel = socket.openReadChannel(),
                    writeChannel = socket.openWriteChannel(),
                    assemblers = assemblers,
                    disassemblers = disassemblers,
                    handlers = handlers
                )

                client.writePacket(ClientHelloPacket())

                try {
                    while (true) {
                        val readPacket = client.awaitPacket() ?: continue
                        client.handlePacket(readPacket)
                    }
                } catch (exception: Exception) {
                    log.error("Exception caught by connected client. Closing connection with client...", exception)
                    socket.close()
                }
            }
        }
    }
}