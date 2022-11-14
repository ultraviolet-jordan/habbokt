package com.habbokt.web

import com.habbokt.web.dao.DatabaseFactory
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installKoinPlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import com.habbokt.web.plugin.routes.account.installAccountPageRoutes
import com.habbokt.web.plugin.routes.asset.installAssetsRoutes
import com.habbokt.web.plugin.routes.captcha.installCaptchaRoutes
import com.habbokt.web.plugin.routes.error.installErrorPageRoutes
import com.habbokt.web.plugin.routes.habblet.installHabbletRoutes
import com.habbokt.web.plugin.routes.index.installIndexPageRoutes
import com.habbokt.web.plugin.routes.me.installMePageRoutes
import com.habbokt.web.plugin.routes.papers.installPapersRoutes
import com.habbokt.web.plugin.routes.register.installRegisterPageRoutes
import com.habbokt.web.plugin.routes.welcome.installWelcomePageRoutes
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
    installAccountPageRoutes()
    installPapersRoutes()
}

inline fun <reified T : Any> inject(): Lazy<T> = KoinPlatformTools.defaultContext().get().inject(null, KoinPlatformTools.defaultLazyMode(), null)
