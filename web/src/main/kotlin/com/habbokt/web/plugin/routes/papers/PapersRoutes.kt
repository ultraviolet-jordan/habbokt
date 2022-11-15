package com.habbokt.web.plugin.routes.papers

import com.habbokt.web.plugin.routes.papers.disclaimer.installDisclaimerRoutes
import com.habbokt.web.plugin.routes.papers.privacy.installPrivacyRoutes
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installPapersRoutes() {
    installDisclaimerRoutes()
    installPrivacyRoutes()
}
