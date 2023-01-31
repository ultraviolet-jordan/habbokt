package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPageService
import com.habbokt.page.respondPng
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.server.response.respond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    private val httpClient: HttpClient
) : BlankPageService(
    get = response@{
        val figure = parameters["figure"] ?: return@response respond(HttpStatusCode.BadRequest)
        val size = parameters["size"] ?: return@response respond(HttpStatusCode.BadRequest)
        val direction = parameters["direction"] ?: return@response respond(HttpStatusCode.BadRequest)
        val headDirection = parameters["head_direction"] ?: return@response respond(HttpStatusCode.BadRequest)
        val crr = parameters["crr"] ?: return@response respond(HttpStatusCode.BadRequest)
        val gesture = parameters["gesture"] ?: return@response respond(HttpStatusCode.BadRequest)
        val frame = parameters["frame"] ?: return@response respond(HttpStatusCode.BadRequest)

        if (direction.toIntOrNull() !in 0..7) return@response respond(HttpStatusCode.BadRequest)
        if (headDirection.toIntOrNull() !in 0..7) return@response respond(HttpStatusCode.BadRequest)

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

        if (response.status != HttpStatusCode.OK) return@response respond(response.status)

        val image = withContext(Dispatchers.IO) {
            ImageIO.read(ByteArrayInputStream(response.body<ByteArray>()))
        }

        return@response respondPng(image)
    }
)