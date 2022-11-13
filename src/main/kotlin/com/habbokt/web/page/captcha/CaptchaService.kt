package com.habbokt.web.page.captcha

import cn.apiclub.captcha.Captcha
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer
import java.awt.Color
import java.awt.Font
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
class CaptchaService {
    fun getCaptchaResponse(): ByteArray {
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

        return ByteArrayOutputStream().apply {
            ImageIO.write(captcha.image, "png", this)
        }.toByteArray()
    }
}