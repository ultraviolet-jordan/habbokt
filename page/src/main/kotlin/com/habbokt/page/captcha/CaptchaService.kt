package com.habbokt.page.captcha

import cn.apiclub.captcha.Captcha
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer
import com.google.inject.Singleton
import com.habbokt.page.BlankPageService
import com.habbokt.page.None
import com.habbokt.page.Png
import com.habbokt.page.png
import com.habbokt.session.CaptchaSession
import io.ktor.server.sessions.get
import io.ktor.server.sessions.set
import java.awt.Color
import java.awt.Font

/**
 * @author Jordan Abraham
 */
@Singleton
class CaptchaService : BlankPageService<CaptchaRequest, Png, None>(
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
        val captchaSession = session.get<CaptchaSession>()
        if (captchaSession == null) {
            session.set(CaptchaSession(captcha.answer))
        } else {
            session.set(captchaSession.copy(captcha = captcha.answer))
        }

        png(captcha.image)
    }
)