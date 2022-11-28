package com.habbokt.web.plugin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging
import org.slf4j.event.Level

/**
 * @author Jordan Abraham
 */
fun Application.installCallLoggingPlugin() {
    install(CallLogging) {
        level = Level.INFO
    }
}