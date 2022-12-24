package com.habbokt.game

import com.google.inject.Guice
import com.habbokt.db.DatabaseConfiguration
import com.habbokt.db.HikariDatabase
import com.habbokt.packet.PacketModule
import dev.misfitlabs.kotlinguice4.getInstance
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.loadCommonConfiguration
import io.ktor.server.netty.NettyApplicationEngine

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>) {
    val applicationEnvironment = commandLineEnvironment(args)
    val applicationEngine = NettyApplicationEngine(applicationEnvironment) { loadCommonConfiguration(applicationEnvironment.config) }

    val databaseConfiguration = DatabaseConfiguration(
        driverClassName = applicationEnvironment.config.property("storage.driverClassName").getString(),
        jdbcUrl = applicationEnvironment.config.property("storage.jdbcUrl").getString(),
        maximumPoolSize = 2,
        isAutoCommit = true,
        transactionIsolation = "TRANSACTION_REPEATABLE_READ",
        enableConsole = false
    )

    val injector = Guice.createInjector(
        GameModule(applicationEngine, databaseConfiguration),
        PacketModule
    )

    val database = injector.getInstance<HikariDatabase>()
    val gameServer = injector.getInstance<GameServer>()
    val gameSynchronizer = injector.getInstance<GameSynchronizer>()

    Runtime.getRuntime().addShutdownHook(ShutdownHook(applicationEngine, database, gameServer, gameSynchronizer))

    database.connect()
    gameSynchronizer.start()
    gameServer.bind()
}