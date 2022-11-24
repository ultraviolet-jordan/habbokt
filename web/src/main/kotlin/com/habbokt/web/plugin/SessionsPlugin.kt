package com.habbokt.web.plugin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.sessions.Sessions

/**
 * @author Jordan Abraham
 */
fun Application.installSessionsPlugin() {
    install(Sessions) {

    }
}