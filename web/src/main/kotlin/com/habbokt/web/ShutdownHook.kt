package com.habbokt.web

import com.habbokt.db.HikariDatabase
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.stop
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

/**
 * @author Jordan Abraham
 */
class ShutdownHook(
    private val applicationEnvironment: ApplicationEnvironment,
    private val applicationEngine: NettyApplicationEngine,
    private val database: HikariDatabase
) : Thread() {
    override fun run() {
        applicationEnvironment.log.info("Running shutdown hook...")
        applicationEnvironment.log.info("Shutting down the database connection...")
        database.close()
        applicationEnvironment.log.info("Shutting down the application engine...")
        applicationEngine.stop(3, 5, TimeUnit.SECONDS)
    }
}