package com.habbokt.game.plugin

import com.habbokt.dao.DAOModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

/**
 * @author Jordan Abraham
 */
fun Application.installKoinPlugin() {
    install(Koin) {
        modules(
            DAOModule
        )
    }
}