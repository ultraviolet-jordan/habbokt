package com.habbokt.web.plugin.auth

import com.habbokt.page.Authentications
import com.habbokt.session.CaptchaSession
import io.ktor.server.auth.AuthenticationConfig
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect

/**
 * @author Jordan Abraham
 */
fun AuthenticationConfig.installCaptchaAuthentication() {
    session<CaptchaSession>(Authentications.Captcha) {
        validate { session ->
            session
        }
        challenge {
            call.respondRedirect("/register") // Registration page.
        }
    }
}