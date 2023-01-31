package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.session.RegistrationSession
import io.ktor.server.sessions.get
import kotlin.random.Random

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPage @Inject constructor(
    private val siteService: SiteService
) : Page<RegisterPageTemplate>(
    template = { session, request ->
        val registrationSession = session.get<RegistrationSession>()

        RegisterPageTemplate(
            site = siteService.site(),
            randomNum = Random.nextInt(0, 10000).toString(),
            registerCaptchaInvalid = request.queryParameters["error"]?.equals("bad_captcha"),
            registerEmailInvalid = request.queryParameters["error"]?.equals("bad_email"),
            registerUsername = registrationSession?.username,
            registerShowPassword = "(Hidden)",
            registerEmail = registrationSession?.email,
            registerDay = registrationSession?.birthDay,
            registerMonth = registrationSession?.birthMonth,
            registerYear = registrationSession?.birthYear,
            registerFigure = registrationSession?.appearance,
            registerGender = registrationSession?.gender
        )
    }
)