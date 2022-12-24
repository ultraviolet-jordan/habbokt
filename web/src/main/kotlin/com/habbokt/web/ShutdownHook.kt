package com.habbokt.web

import com.habbokt.db.HikariDatabase
import io.ktor.server.engine.stop
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

/**
 * @author Jordan Abraham
 */
class ShutdownHook(
    private val applicationEngine: NettyApplicationEngine,
    private val database: HikariDatabase
) : Thread() {
    override fun run() {
        applicationEngine.environment.log.info("Running shutdown hook...")
        database.close()
        applicationEngine.environment.log.info("Stopping the application engine...")
        applicationEngine.stop(3, 5, TimeUnit.SECONDS)
    }
}