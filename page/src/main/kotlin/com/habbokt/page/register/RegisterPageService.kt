package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.argon2.Argon2Service
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage
import com.habbokt.session.CaptchaSession
import com.habbokt.session.RegistrationSession
import com.habbokt.session.UserSession
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPageService @Inject constructor(
    private val playersService: PlayersService,
    private val argon2Service: Argon2Service
) : PageService<RegisterPage>(
    get = {
        respondHtmlPage(it)
    },

    post = response@{
        // User may or may not have a registration session depending on how many times they typed wrong captcha for example.
        val registrationSession = sessions.get<RegistrationSession>()

        val parameters = receiveParameters()
        val username = registrationSession?.username ?: parameters["bean.avatarName"]
        val captchaResponse = parameters["bean.captchaResponse"] // There is always a new captcha response when posting to registration.
        val password = argon2Service.hash(12, 65536, 1, registrationSession?.password?.toByteArray() ?: parameters["retypedPassword"]?.toByteArray())
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
            return@response respondRedirect("/register") // TODO Better validation on the incoming data.
        }

        // Create registration session before we attempt redirects for soft registration errors.
        // Since there is always a new captcha response, no need to include it in the session.
        sessions.set(
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

        // We do not have to validate if the user has session because this function is authenticated by captcha.
        if (captchaResponse != sessions.get<CaptchaSession>()?.captcha) {
            return@response respondRedirect("/register?error=bad_captcha")
        }

        if (email.isEmpty()) {
            return@response respondRedirect("/register?error=bad_email")
        }

        application.environment.log.info("Registered! Username=$username, Password=$password, Email=$email, Appearance=$appearance, Gender=$gender")

        removeRegisterSessions()
        val sessions = sessions
        if (sessions.get<UserSession>() != null) {
            sessions.clear<UserSession>()
        }

        val player = playersService.createPlayer(
            name = username,
            password = password,
            email = email,
            figure = appearance,
            sex = gender,
            ssoTicket = "",
            motto = ""
        ) ?: return@response respondRedirect("/register")

        // If the new player was not added to the database.

        // Set a new authenticated user session.
        sessions.set(
            UserSession(
                authenticated = true,
                userId = player.id.toString()
            )
        )
        respondRedirect("/welcome")
    }
) {
    suspend fun handleCancelRequest(call: ApplicationCall) {
        call.removeRegisterSessions()
        call.respondRedirect("/") // Homepage
    }
}

private fun ApplicationCall.removeRegisterSessions() {
    if (sessions.get<CaptchaSession>() != null) {
        sessions.clear<CaptchaSession>()
    }
    if (sessions.get<RegistrationSession>() != null) {
        sessions.clear<RegistrationSession>()
    }
}