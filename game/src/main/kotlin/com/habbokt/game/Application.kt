package com.habbokt.game

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
fun Application.module() {
    val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
    val selector = ActorSelectorManager(dispatcher)

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

            val readChannel = socket.openReadChannel()
            val writeChannel = socket.openWriteChannel()

            launch(Dispatchers.IO) {

            }
        }
    }
}