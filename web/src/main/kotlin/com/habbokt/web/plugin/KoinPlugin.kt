package com.habbokt.web.plugin

import com.habbokt.dao.DAOModule
import com.habbokt.templating.CompilerModule
import com.habbokt.web.plugin.koin.argon2.Argon2Module
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

/**
 * @author Jordan Abraham
 */
fun Application.installKoinPlugin() {
    install(Koin) {
        modules(
            Argon2Module,
            DAOModule,
            CompilerModule
        )
    }
}
