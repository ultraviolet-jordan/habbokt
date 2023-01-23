package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.threading.Synchronizer
import io.ktor.server.application.ApplicationEnvironment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * @author Jordan Abraham
 */
@Singleton
class GameSynchronizer @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment,
    private val dispatcher: CoroutineDispatcher,
    private val connectionPool: ConnectionPool,
    private val executorService: ScheduledExecutorService
) : Synchronizer {
    private var tick = 0

    override fun start() {
        executorService.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS)
    }

    override fun stop() {
        executorService.shutdown()
    }

    @OptIn(ExperimentalTime::class)
    override fun run() {
        try {
            if (executorService.isShutdown) return

            val time = measureTime {
                runBlocking(dispatcher) {
                    // Asynchronously process all connected clients read pools.
                    connectionPool.map { async { it.processReadPool() } }.awaitAll()
                    // Asynchronously process all connected clients write pools.
                    connectionPool.map { async { it.processWritePool() } }.awaitAll()
                }
            }

            tick++

            applicationEnvironment.log.info("Game Synchronizer: Time: $time, Clients: ${connectionPool.size}, Tick: $tick")
        } catch (exception: Exception) {
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }
}