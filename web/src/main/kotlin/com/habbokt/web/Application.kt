package com.habbokt.web

import com.habbokt.api.inject
import com.habbokt.dao.DatabaseFactory
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.site.SiteDAO
import com.habbokt.dao.site.SiteService
import com.habbokt.web.plugin.installAuthenticationPlugin
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installKoinPlugin
import com.habbokt.web.plugin.installSessionsPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import com.habbokt.web.plugin.routes.account.installAccountPageRoutes
import com.habbokt.web.plugin.routes.asset.installAssetsRoutes
import com.habbokt.web.plugin.routes.captcha.installCaptchaRoutes
import com.habbokt.web.plugin.routes.client.installClientPageRoutes
import com.habbokt.web.plugin.routes.community.installCommunityRoutes
import com.habbokt.web.plugin.routes.error.installErrorPageRoutes
import com.habbokt.web.plugin.routes.habblet.installHabbletRoutes
import com.habbokt.web.plugin.routes.index.installIndexPageRoutes
import com.habbokt.web.plugin.routes.me.installMePageRoutes
import com.habbokt.web.plugin.routes.papers.installPapersRoutes
import com.habbokt.web.plugin.routes.register.installRegisterPageRoutes
import com.habbokt.web.plugin.routes.security.installSecurityPageRoutes
import com.habbokt.web.plugin.routes.welcome.installWelcomePageRoutes
import io.ktor.server.application.Application
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
fun Application.module() {
    // Load DatabaseFactory.
    DatabaseFactory.init(
        driverClassName = environment.config.property("storage.driverClassName").getString(),
        jdbcUrl = environment.config.property("storage.jdbcURL").getString(),
        useConsole = environment.config.property("h2.console.enabled").getString().toBoolean()
    )

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
    installCommunityRoutes()
    installSecurityPageRoutes()
    installClientPageRoutes()

    // ====================== Temporary Database Setup ====================== //
    val siteService by inject<SiteService>()
    runBlocking {
        siteService.createSite(
            SiteDAO(
                siteName = "Habbo Hotel",
                sitePath = "http://localhost",
                staticContentPath = "http://localhost",
                serverOnline = true,
                loaderGameIp = "127.0.0.1",
                loaderGamePort = 43594,
                loaderDcr = "http://localhost/dcr/v31/habbo.dcr?",
                loaderVariables = "http://localhost/dcr/v31/gamedata/external_variables.txt?",
                loaderTexts = "http://localhost/dcr/v31/gamedata/external_texts.txt?"
            )
        )
    }

    val playersService by inject<PlayersService>()
    runBlocking {
        playersService.createPlayer(
            username = "jordan",
            password = "\$argon2i\$v=19\$m=65536,t=12,p=1\$hk7pQ0uj76PrcB9I+Jc4CQ\$P68lqFBz6xGKACjmdbIuPn0voRyX4shoeTdvNraSLYQ", // "password1"
            email = "test@gmail.com",
            appearance = "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-",
            gender = "F",
            ssoTicket = ""
        )
    }
}