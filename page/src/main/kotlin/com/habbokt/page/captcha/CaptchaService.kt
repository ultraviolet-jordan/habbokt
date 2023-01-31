package com.habbokt.page.captcha

import cn.apiclub.captcha.Captcha
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer
import com.google.inject.Singleton
import com.habbokt.page.BlankPageService
import com.habbokt.page.respondPng
import com.habbokt.session.CaptchaSession
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set
import java.awt.Color
import java.awt.Font

/**
 * @author Jordan Abraham
 */
@Singleton
class CaptchaService : BlankPageService(
    get = {
        val colors = listOf(
            Color.BLACK
        )

        val fonts = listOf(
            Font("Arial", Font.PLAIN, 45),
            Font("Arial", Font.BOLD, 45)
        )

        val captcha = Captcha
            .Builder(200, 50)
            .addText(DefaultWordRenderer(colors, fonts))
            .build()

        // Modify or create new captcha session when generating a new captcha to the user.
        val session = sessions.get<CaptchaSession>()
        if (session == null) {
            sessions.set(CaptchaSession(captcha.answer))
        } else {
            sessions.set(session.copy(captcha = captcha.answer))
        }

        respondPng(captcha.image)
    }
)