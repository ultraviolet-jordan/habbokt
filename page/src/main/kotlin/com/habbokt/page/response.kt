package com.habbokt.page

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.pebble.PebbleContent
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
    respond(statusCode, html.content)
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

suspend inline fun <reified T : PageTemplate, reified R : PageRequest> Page<T, R>.html(request: R): Html = template(request)
    .let { PebbleContent(it.path, it) }
    .let(::Html)

fun BufferedImage.png(): Png = ByteArrayOutputStream()
    .apply { ImageIO.write(this@png, "png", this) }
    .toByteArray()
    .let(::Png)

fun Pair<String, String>.ajax(): Ajax = Ajax("{\"$first\":\"$second\"}")
fun String.redirect(): Redirect = Redirect(this)