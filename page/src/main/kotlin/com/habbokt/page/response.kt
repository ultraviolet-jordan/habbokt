package com.habbokt.page

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header
import io.ktor.server.response.respond
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
internal suspend fun ApplicationCall.respondHtmlPage(html: String) {
    htmlHeader(html.length)
    respond(HttpStatusCode.OK, html)
}

internal suspend fun ApplicationCall.respondAjax(json: String) {
    xjsonHeader(json)
    htmlHeader(0)
    respond(HttpStatusCode.OK)
}

internal suspend fun ApplicationCall.respondPng(image: BufferedImage) {
    val bytes = try {
        ByteArrayOutputStream().apply {
            ImageIO.write(image, "png", this)
        }.toByteArray()
    } catch (exception: Exception) {
        throw RuntimeException("RuntimeException when writing the image to the buffer.")
    }
    pngHeader(bytes.size)
    respond(HttpStatusCode.OK, bytes)
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