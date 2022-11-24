package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.page.Template
import com.habbokt.session.RegistrationSession
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import io.ktor.server.sessions.get
import kotlin.random.Random

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPage @Inject constructor(
    private val siteService: SiteService
) : Page<RegisterPageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<RegisterPageTemplate> = Template {
        val session = sessions.get<RegistrationSession>()

        RegisterPageTemplate(
            site = siteService.site(),
            randomNum = Random.nextInt(0, 10000).toString(),
            registerCaptchaInvalid = parameters["error"]?.equals("bad_captcha"),
            registerEmailInvalid = parameters["error"]?.equals("bad_email"),
            registerUsername = session?.username,
            registerShowPassword = "(Hidden)",
            registerEmail = session?.email,
            registerDay = session?.birthDay,
            registerMonth = session?.birthMonth,
            registerYear = session?.birthYear,
            registerFigure = session?.appearance,
            registerGender = session?.gender
        )
    }
}