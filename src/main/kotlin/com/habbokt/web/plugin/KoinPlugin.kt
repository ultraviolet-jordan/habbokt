package com.habbokt.web.plugin

import com.habbokt.web.compiler.compilerModule
import com.habbokt.web.model.Site
import com.habbokt.web.page.captcha.captchaModule
import com.habbokt.web.page.error.errorPageModule
import com.habbokt.web.page.habblet.habbletModule
import com.habbokt.web.page.index.indexPageModule
import com.habbokt.web.page.me.mePageModule
import com.habbokt.web.page.register.registerPageModule
import com.habbokt.web.page.welcome.welcomePageModule
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

            module(createdAtStart = true) {
                single { Argon2Factory.create() }
            }
        )
    }
}
