package com.habbokt.web.page.captcha

import cn.apiclub.captcha.Captcha
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer
import com.habbokt.web.session.CaptchaSession
import io.ktor.server.application.ApplicationCall
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set
import java.awt.Color
import java.awt.Font
import java.io.ByteArrayOutputStream
import java.lang.RuntimeException
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
class CaptchaService {
    fun getCaptchaResponse(call: ApplicationCall): ByteArray {
        val colors = listOf(
            Color.BLACK
        )

        val fonts = listOf(
            Font("Arial", Font.PLAIN, 45),
            Font("Arial", Font.BOLD, 45)
        )

        val wordRenderer = DefaultWordRenderer(colors, fonts)
        val captcha = Captcha
            .Builder(200, 50)
            .addText(wordRenderer)
            .build()

        println("Captcha Service Answer: ${captcha.answer}")

        val bytes = try {
            ByteArrayOutputStream().apply {
                ImageIO.write(captcha.image, "png", this)
            }.toByteArray()
        } catch (exception: Exception) {
            throw RuntimeException("Captcha threw a RuntimeException when writing the image to the buffer.")
        }

        val session = call.sessions.get<CaptchaSession>()
        if (session == null) {
            call.sessions.set(CaptchaSession(captcha.answer))
        } else {
            call.sessions.set(session.copy(captcha = captcha.answer))
        }

        return bytes
    }
}
