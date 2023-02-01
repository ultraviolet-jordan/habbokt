package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import com.habbokt.page.respondRedirect
import com.habbokt.session.CaptchaSession
import com.habbokt.session.RegistrationSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.CurrentSession
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPageRouting @Inject constructor(
    private val service: RegisterPageService
) : PageRouting(
    routing = {
        get("/register") {
            call.respondHtml(HttpStatusCode.OK, service.getRequest(RegisterPageRequest.Empty))
        }
        authenticate(Authentications.Captcha) {
            post("/register") {
                val session = call.sessions
                val registrationSession = session.get<RegistrationSession>()

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
                    return@post call.respondRedirect("/register") // TODO Better validation on the incoming data.
                }

                // Create registration session before we attempt redirects for soft registration errors.
                // Since there is always a new captcha response, no need to include it in the session.
                call.sessions.set(RegistrationSession(username, password, email, birthDay, birthMonth, birthYear, appearance, gender))

                // We do not have to validate if the user has session because this function is authenticated by captcha.
                if (captchaResponse != session.get<CaptchaSession>()?.captcha) {
                    return@post call.respondRedirect("/register?error=bad_captcha")
                }

                if (email.isEmpty()) {
                    return@post call.respondRedirect("/register?error=bad_email")
                }

                session.removeRegisterSessions()

                val request = RegisterPageRequest(
                    session = session,
                    badCaptcha = call.request.queryParameters["error"]?.equals("bad_captcha"),
                    badEmail = call.request.queryParameters["error"]?.equals("bad_email"),
                    username = username,
                    password = password,
                    email = email,
                    birthDay = birthDay,
                    birthMonth = birthMonth,
                    birthYear = birthYear,
                    appearance = appearance,
                    gender = gender
                )

                call.respondRedirect(service.postRequest(request))
            }
        }
        get("/register/cancel") {
            call.sessions.removeRegisterSessions()
            call.respondRedirect("/")
        }
    }
)

private fun CurrentSession.removeRegisterSessions() {
    if (get<CaptchaSession>() != null) {
        clear<CaptchaSession>()
    }
    if (get<RegistrationSession>() != null) {
        clear<RegistrationSession>()
    }
}