package com.habbokt.game

import com.habbokt.db.DatabaseResourceBuilder
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
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
    DatabaseResourceBuilder.connect {
        driverClassName = environment.config.property("storage.driverClassName").getString()
        jdbcUrl = environment.config.property("storage.jdbcUrl").getString()
        maximumPoolSize = 4
    }

    runBlocking {
        val server = aSocket(selector).tcp().bind("127.0.0.1", environment.config.port) {
            reuseAddress = true
        }

        log.info("Responding at http://127.0.0.1:${environment.config.port}")

        while (true) {
            val socket = server.accept()

            launch(Dispatchers.IO) {

            }
        }
    }
}