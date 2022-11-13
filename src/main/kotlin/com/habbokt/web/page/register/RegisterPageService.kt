package com.habbokt.web.page.register

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import com.habbokt.web.session.CaptchaSession
import com.habbokt.web.session.RegistrationSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
class RegisterPageService(
    private val compiler: Compiler
) : PageService<RegisterPage> {
    override suspend fun respondPage(call: ApplicationCall, page: RegisterPage) {
        val sessions = call.sessions
        // Remove these sessions when this page loads since new ones will be created again.
        if (sessions.get<CaptchaSession>() != null) {
            sessions.clear<CaptchaSession>()
        }
        if (sessions.get<RegistrationSession>() != null) {
            sessions.clear<RegistrationSession>()
        }

        val html = page.html(sessions, call.request.queryParameters, compiler)
        call.apply {
            htmlHeaders(html.length)
        }.respond(HttpStatusCode.OK, html)
    }

    suspend fun respondRegistration(call: ApplicationCall) {
        // If the user never got a Captcha.
        val captchaSession = call.sessions.get<CaptchaSession>()
        if (captchaSession == null) {
            call.respondRedirect("/register")
            return
        }

        // User may or may not have a registration session depending on how many times they typed wrong captcha for example.
        val registrationSession = call.sessions.get<RegistrationSession>()

        val parameters = call.receiveParameters()
        val username = registrationSession?.username ?: parameters["bean.avatarName"]
        val captchaResponse = parameters["bean.captchaResponse"] // There is always a new captcha response when posting to registration.
        val password = registrationSession?.password ?: parameters["retypedPassword"]
        val email = registrationSession?.email ?: parameters["bean.email"]
        val birthDay = registrationSession?.birthDay ?: parameters["bean.day"]
        val birthMonth = registrationSession?.birthMonth ?: parameters["bean.month"]
        val birthYear = registrationSession?.birthYear ?: parameters["bean.year"]
        val appearance = registrationSession?.appearance ?: parameters["randomFigure"]?.substring(2) ?: parameters["bean.figure"]
        val gender = registrationSession?.gender ?: parameters["randomFigure"]?.substring(0, 1) ?: parameters["bean.gender"]

        // Validate the form fields.
        if (username.isNullOrEmpty() ||
            captchaResponse.isNullOrEmpty() ||
            password.isNullOrEmpty() ||
            email.isNullOrEmpty() ||
            birthDay.isNullOrEmpty() ||
            birthMonth.isNullOrEmpty() ||
            birthYear.isNullOrEmpty() ||
            appearance.isNullOrEmpty() ||
            gender.isNullOrEmpty()
        ) {
            call.respondRedirect("/register") // TODO Better validation on the incoming data.
            return
        }

        // Create registration session before we attempt redirects for soft registration errors.
        // Since there is always a new captcha response, no need to include it in the session.
        call.sessions.set(
            RegistrationSession(
                username,
                password,
                email,
                birthDay,
                birthMonth,
                birthYear,
                appearance,
                gender
            )
        )

        // TODO Better validation on the incoming data.

        if (captchaResponse != captchaSession.captcha) {
            call.respondRedirect("/register?error=bad_captcha")
            return
        }

        if (email.isEmpty()) {
            call.respondRedirect("/register?error=bad_email")
            return
        }

        call.application.environment.log.info("Registered! Username=$username, Password=$password, Email=$email, Appearance=$appearance, Gender=$gender")

        // TODO Welcome page redirect.
    }
}
