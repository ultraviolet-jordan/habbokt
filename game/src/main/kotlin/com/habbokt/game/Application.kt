package com.habbokt.game

import com.google.inject.Guice
import com.habbokt.db.DatabaseModule
import com.habbokt.db.HikariDatabase
import com.habbokt.packet.PacketModule
import dev.misfitlabs.kotlinguice4.getInstance
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.netty.NettyApplicationEngine

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>) {
    val injector = Guice.createInjector(
        GameModule(args),
        PacketModule
    )

    val applicationEnvironment = injector.getInstance<ApplicationEnvironment>()
    val applicationEngine = injector.getInstance<NettyApplicationEngine>()
    val gameServer = injector.getInstance<GameServer>()
    val gameSynchronizer = injector.getInstance<GameSynchronizer>()
    val database =  Guice.createInjector(DatabaseModule(injector.getInstance())).getInstance<HikariDatabase>()

    Runtime.getRuntime().addShutdownHook(ShutdownHook(applicationEnvironment, applicationEngine, database, gameServer, gameSynchronizer))

    database.connect()
    gameSynchronizer.start()
    gameServer.bind()
}