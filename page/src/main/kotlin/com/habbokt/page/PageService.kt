package com.habbokt.page

import com.habbokt.templating.Compiler
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header
import io.ktor.server.response.respond
import io.ktor.server.sessions.sessions
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
abstract class PageService<P : Page<*>>(
    private val page: P,
    private val compiler: Compiler?
) {
    open suspend fun handleGetRequest(call: ApplicationCall) {
        throw RuntimeException("Unhandled GET request.")
    }
    open suspend fun handlePostRequest(call: ApplicationCall) {
        throw RuntimeException("Unhandled POST request.")
    }

    protected suspend fun ApplicationCall.respondHtmlPage() {
        require(compiler != null)
        val template = page
            .template(sessions, request.queryParameters)
            .block
            .invoke()
            .also { it.configure() }
        require(template.path.isNotEmpty())
        val html = compiler.compile(template.path, template)
        htmlHeader(html.length)
        respond(HttpStatusCode.OK, html)
    }

    protected suspend fun ApplicationCall.respondAjax(json: String) {
        xjsonHeader(json)
        htmlHeader(0)
        respond(HttpStatusCode.OK)
    }

    protected suspend fun ApplicationCall.respondPng(image: BufferedImage) {
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
}