package com.habbokt.web.plugin

import com.habbokt.web.dao.DatabaseFactory
import com.habbokt.web.model.Site
import com.habbokt.web.plugin.koin.captcha.captchaModule
import com.habbokt.web.plugin.koin.compiler.compilerModule
import com.habbokt.web.plugin.koin.error.errorPageModule
import com.habbokt.web.plugin.koin.habblet.habbletModule
import com.habbokt.web.plugin.koin.index.indexPageModule
import com.habbokt.web.plugin.koin.me.mePageModule
import com.habbokt.web.plugin.koin.register.registerPageModule
import com.habbokt.web.plugin.koin.welcome.welcomePageModule
import de.mkammerer.argon2.Argon2Factory
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
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
            module(createdAtStart = true) {
                single { Argon2Factory.create() }
                single { DatabaseFactory.createPlayersDAO() }
            },
            // Web-server
            compilerModule(),
            // Pages
            indexPageModule(site),
            registerPageModule(site),
            errorPageModule(site),
            welcomePageModule(site),
            mePageModule(site),
            // Habblet
            habbletModule(),
            // Captcha
            captchaModule(),
        )
    }
}
