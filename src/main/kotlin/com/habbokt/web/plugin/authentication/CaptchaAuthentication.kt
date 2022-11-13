package com.habbokt.web.plugin.authentication

import com.habbokt.web.session.CaptchaSession
import com.habbokt.web.session.RegistrationSession
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
