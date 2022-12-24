package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.threading.Synchronizer
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
@Singleton
class GameSynchronizer @Inject constructor(
    private val applicationEngine: NettyApplicationEngine,
    private val forkJoinPool: ForkJoinPool,
    private val connectionPool: ConnectionPool
) : Synchronizer {
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val dispatcher = forkJoinPool.asCoroutineDispatcher()

    private var tick = 0

    override fun start() {
        executor.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS)
    }

    override fun stop() {
        executor.shutdown()
        dispatcher.close()
        forkJoinPool.shutdown()
        applicationEngine.environment.log.info("Stopped the game synchronizer.")
    }

    @OptIn(ExperimentalTime::class)
    override fun run() {
        try {
            if (executor.isShutdown || forkJoinPool.isShutdown) return

            val time = measureTime {
                runBlocking(dispatcher) {
                    // Asynchronously process all connected clients read pools.
                    connectionPool.map { async { it.processReadPool() } }.awaitAll()
                    // Asynchronously process all connected clients write pools.
                    connectionPool.map { async { it.processWritePool() } }.awaitAll()
                }
            }

            tick++

            applicationEngine.environment.log.info("Game Synchronizer: Time: $time, Threads: ${forkJoinPool.parallelism}, Clients: ${connectionPool.size}, Tick: $tick")
        } catch (exception: Exception) {
            applicationEngine.environment.log.error(exception.stackTraceToString())
        }
    }
}