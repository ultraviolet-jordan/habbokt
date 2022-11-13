package com.habbokt.web.page.register

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import com.habbokt.web.session.RegistrationSession
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import io.ktor.server.sessions.get
import kotlin.collections.set
import kotlin.random.Random

/**
 * @author Jordan Abraham
 */
class RegisterPage(
    private val site: Site
) : Page {
    override fun templateName(): String = "register.tpl"

    override fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mutableMapOf(
        "site" to site,
        "randomNum" to Random.nextInt(0, 10000).toString()
    ).also {
        if (parameters["error"].equals("bad_captcha")) {
            it["registerCaptchaInvalid"] = true
        }
        if (parameters["error"].equals("bad_email")) {
            it["registerEmailInvalid"] = true
        }
        val session = sessions.get<RegistrationSession>()
        if (session != null) {
            it["registerUsername"] = session.username
            it["registerShowPassword"] = session.password.replace(Regex("(?s)."), "*")
            it["registerEmail"] = session.email
            it["registerDay"] = session.birthDay
            it["registerMonth"] = session.birthMonth
            it["registerYear"] = session.birthYear
            // TODO Fix the appearance and gender of the character from the session.
        }
    }
}
