package com.habbokt.web.plugin

import com.habbokt.web.plugin.koin.argon2.argon2Module
import com.habbokt.web.plugin.koin.compiler.compilerModule
import com.habbokt.web.plugin.koin.dao.daoModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

/**
 * @author Jordan Abraham
 */
fun Application.installKoinPlugin() {
    install(Koin) {
        modules(
            argon2Module(),
            // Dao/Database
            daoModule(),
            // Web-server
            compilerModule(),
        )
    }
}
