package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.threading.Synchronizer
import io.ktor.server.application.ApplicationEnvironment
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * @author Jordan Abraham
 */
@Singleton
class GameSynchronizer @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment,
    private val gameThreadDispatcher: GameThreadDispatcher,
    private val connectionPool: ConnectionPool,
    private val gameThread: GameThread
) : Synchronizer {
    private var tick = 0

    override fun start() {
        gameThread.executor.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS)
    }

    override fun stop() {
        gameThread.executor.shutdown()
        gameThreadDispatcher.forkJoinPool.shutdown()
    }

    @OptIn(ExperimentalTime::class)
    override fun run() {
        try {
            if (gameThread.executor.isShutdown || gameThreadDispatcher.forkJoinPool.isShutdown) return

            val time = measureTime {
                runBlocking(gameThreadDispatcher.dispatcher) {
                    // Asynchronously process all connected clients read pools.
                    connectionPool.map { async { it.processReadPool() } }.awaitAll()
                    // Asynchronously process all connected clients write pools.
                    connectionPool.map { async { it.processWritePool() } }.awaitAll()
                }
            }

            tick++

            applicationEnvironment.log.info("Game Synchronizer: Time: $time, Threads: ${gameThreadDispatcher.forkJoinPool.parallelism}, Clients: ${connectionPool.size}, Tick: $tick")
        } catch (exception: Exception) {
            applicationEnvironment.log.error(exception.stackTraceToString())
        }
    }
}