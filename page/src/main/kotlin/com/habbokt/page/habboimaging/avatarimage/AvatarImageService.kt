package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    page: BlankPage,
    private val httpClient: HttpClient
) : BlankPageService(page) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        val figure = call.parameters["figure"] ?: return call.respond(HttpStatusCode.BadRequest)
        val size = call.parameters["size"] ?: return call.respond(HttpStatusCode.BadRequest)
        val direction = call.parameters["direction"] ?: return call.respond(HttpStatusCode.BadRequest)
        val headDirection = call.parameters["head_direction"] ?: return call.respond(HttpStatusCode.BadRequest)
        val crr = call.parameters["crr"] ?: return call.respond(HttpStatusCode.BadRequest)
        val gesture = call.parameters["gesture"] ?: return call.respond(HttpStatusCode.BadRequest)
        val frame = call.parameters["frame"] ?: return call.respond(HttpStatusCode.BadRequest)

        if (direction.toIntOrNull() !in 0..7) return call.respond(HttpStatusCode.BadRequest)
        if (headDirection.toIntOrNull() !in 0..7) return call.respond(HttpStatusCode.BadRequest)

        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "habbo.com"
                path("habbo-imaging/avatarimage")
                parameters.append("figure", figure)
                parameters.append("size", size)
                parameters.append("direction", direction)
                parameters.append("head_direction", direction)
                parameters.append("crr", crr)
                parameters.append("gesture", gesture)
                parameters.append("frame", frame)
            }
        }

        if (response.status != HttpStatusCode.OK) return call.respond(response.status)

        val image = withContext(Dispatchers.IO) {
            ImageIO.read(ByteArrayInputStream(response.body<ByteArray>()))
        }

        call.respondPng(image)
    }
}