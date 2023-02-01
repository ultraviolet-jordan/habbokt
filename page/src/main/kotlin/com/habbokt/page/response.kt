package com.habbokt.page

import com.habbokt.templating.Compiler
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
internal suspend fun ApplicationCall.respondHtml(
    statusCode: HttpStatusCode,
    html: Html
) {
    htmlHeader(html.string.length)
    respond(statusCode, html.string)
}

internal suspend fun ApplicationCall.respondAjax(
    statusCode: HttpStatusCode,
    ajax: Ajax
) {
    xjsonHeader(ajax.json)
    htmlHeader(0)
    respond(statusCode)
}

internal suspend fun ApplicationCall.respondPng(
    statusCode: HttpStatusCode,
    png: Png
) {
    pngHeader(png.bytes.size)
    respond(statusCode, png.bytes)
}

internal suspend fun ApplicationCall.respondRedirect(
    redirect: Redirect
) {
    respondRedirect(url = redirect.path)
}

private fun ApplicationCall.htmlHeader(contentLength: Int) {
    response.header(HttpHeaders.ContentType, "text/html")
    response.header(HttpHeaders.ContentLength, contentLength)
}

private fun ApplicationCall.xjsonHeader(json: String) {
    response.header("X-JSON", json)
}

private fun ApplicationCall.pngHeader(contentLength: Int) {
    response.header(HttpHeaders.ContentType, "image/png")
    response.header(HttpHeaders.ContentLength, contentLength)
}

suspend inline fun <reified T : PageTemplate, reified R : PageRequest> R.html(page: Page<T, R>, compiler: Compiler): Html = Html(
    page.template(this).let {
        if (it.path.isEmpty()) "" else compiler.compile(it.path, it.filterValues { v -> v != null })
    }
)

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