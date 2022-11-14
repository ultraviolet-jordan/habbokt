package com.habbokt.web.plugin.koin.papers

import com.habbokt.web.plugin.koin.papers.disclaimer.installDisclaimerRoutes
import com.habbokt.web.plugin.koin.papers.privacy.installPrivacyRoutes
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installPapersRoutes() {
    installDisclaimerRoutes()
    installPrivacyRoutes()
}
