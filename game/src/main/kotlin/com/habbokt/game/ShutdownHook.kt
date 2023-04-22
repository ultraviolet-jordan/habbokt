package com.habbokt.game

import com.habbokt.db.HikariDatabase
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.stop
import io.ktor.util.logging.Logger
import java.util.concurrent.TimeUnit

/**
 * @author Jordan Abraham
 */
class ShutdownHook(
    private val logger: Logger,
    private val applicationEngine: ApplicationEngine,
    private val database: HikariDatabase,
    private val gameServer: GameServer,
    private val gameSynchronizer: GameSynchronizer
) : Thread() {
    override fun run() {
        logger.info("Running shutdown hook...")
        logger.info("Shutting down the game server...")
        gameServer.close()
        logger.info("Shutting down the game synchronizer...")
        gameSynchronizer.stop()
        logger.info("Shutting down the database connection...")
        database.close()
        logger.info("Shutting down the application engine...")
        applicationEngine.stop(3, 5, TimeUnit.SECONDS)
    }
}