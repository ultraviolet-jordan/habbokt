package com.habbokt.page

import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
interface ResponseType

class Html(
    val string: String
) : ResponseType

class Png(
    val bytes: ByteArray
) : ResponseType

class Ajax(
    val json: String
) : ResponseType

class Redirect(
    val path: String
) : ResponseType

object None : ResponseType

suspend inline fun <reified T : PageTemplate, reified R : PageRequest> R.html(page: Page<T, R>): Html = Html(page.template(this).compile())

fun png(image: BufferedImage): Png = Png(
    try {
        ByteArrayOutputStream().apply {
            ImageIO.write(image, "png", this)
        }.toByteArray()
    } catch (exception: Exception) {
        throw RuntimeException("RuntimeException when writing the image to the buffer.")
    }
)

fun ajax(json: String): Ajax = Ajax(json)

fun redirect(path: String): Redirect = Redirect(path)