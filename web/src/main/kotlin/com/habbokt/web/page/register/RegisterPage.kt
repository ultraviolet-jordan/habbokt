package com.habbokt.web.page.register

import com.habbokt.dao.site.SiteService
import com.habbokt.web.inject
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
object RegisterPage : Page {
    private val dao by inject<SiteService>()

    override fun templateName(): String = "register.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mutableMapOf(
        "site" to dao.site(),
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
            it["registerShowPassword"] = "(Hidden)"
            it["registerEmail"] = session.email
            it["registerDay"] = session.birthDay
            it["registerMonth"] = session.birthMonth
            it["registerYear"] = session.birthYear
            it["registerFigure"] = session.appearance
            it["registerGender"] = session.gender
        }
    }
}
