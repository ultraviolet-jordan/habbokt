package com.habbokt.web

import com.habbokt.web.dao.DatabaseFactory
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installKoinPlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import com.habbokt.web.plugin.koin.asset.installAssetsRoutes
import com.habbokt.web.plugin.koin.captcha.installCaptchaRoutes
import com.habbokt.web.plugin.koin.error.installErrorPageRoutes
import com.habbokt.web.plugin.koin.habblet.installHabbletRoutes
import com.habbokt.web.plugin.koin.index.installIndexPageRoutes
import com.habbokt.web.plugin.koin.me.installMePageRoutes
import com.habbokt.web.plugin.koin.register.installRegisterPageRoutes
import com.habbokt.web.plugin.koin.welcome.installWelcomePageRoutes
import io.ktor.server.application.Application
import org.koin.mp.KoinPlatformTools

/**
 * @author Jordan Abraham
 */
fun Application.module() {
    // Load DatabaseFactory.
    DatabaseFactory.init(environment.config)

    // Install web-server plugins.
    installKoinPlugin()
    installStatusPagesPlugin()
    installCallLoggingPlugin()
    installSessionsPlugin()
    installAuthenticationPlugin()

    // Install web-server routes.
    installAssetsRoutes()
    installIndexPageRoutes()
    installRegisterPageRoutes()
    installErrorPageRoutes()
    installWelcomePageRoutes()
    installMePageRoutes()
    installHabbletRoutes()
    installCaptchaRoutes()
}

inline fun <reified T : Any> inject(): Lazy<T> = KoinPlatformTools.defaultContext().get().inject(null, KoinPlatformTools.defaultLazyMode(), null)
