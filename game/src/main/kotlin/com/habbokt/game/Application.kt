package com.habbokt.game

import com.google.inject.Guice
import com.habbokt.db.DatabaseResourceBuilder
import com.habbokt.packet.PacketModule
import dev.misfitlabs.kotlinguice4.getInstance
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.game() {
    // Database
    DatabaseResourceBuilder.connect {
        driverClassName = environment.config.property("storage.driverClassName").getString()
        jdbcUrl = environment.config.property("storage.jdbcUrl").getString()
        maximumPoolSize = 2
    }

    // Guice
    val injector = Guice.createInjector(
        GameModule(this),
        PacketModule
    )

    injector.getInstance<GameServer>().bind()
}