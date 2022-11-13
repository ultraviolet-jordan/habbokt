package com.habbokt.web.plugin

import com.habbokt.web.compiler.compilerModule
import com.habbokt.web.model.Site
import com.habbokt.web.page.error.errorPageModule
import com.habbokt.web.page.index.indexPageModule
import com.habbokt.web.page.register.registerPageModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

/**
 * @author Jordan Abraham
 */
fun Application.installKoinPlugin() {
    val site = Site(
        siteName = "Habbo Hotel",
        staticContentPath = "http://localhost"
    )

    install(Koin) {
        modules(
            compilerModule(),
            indexPageModule(site),
            registerPageModule(site),
            errorPageModule(site)
        )
    }
}