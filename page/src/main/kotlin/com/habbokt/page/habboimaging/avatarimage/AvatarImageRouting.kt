package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.respondPng
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageRouting @Inject constructor(
    private val service: AvatarImageService
) : PageRouting(
    routing = {
        authenticate(Authentications.User) {
            get("/habbo-imaging/avatarimage") {
                val parameters = call.parameters
                val figure = parameters["figure"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val size = parameters["size"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val direction = parameters["direction"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val headDirection = parameters["head_direction"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val crr = parameters["crr"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val gesture = parameters["gesture"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val frame = parameters["frame"] ?: return@get call.respond(HttpStatusCode.BadRequest)

                if (direction.toIntOrNull() !in 0..7) return@get call.respond(HttpStatusCode.BadRequest)
                if (headDirection.toIntOrNull() !in 0..7) return@get call.respond(HttpStatusCode.BadRequest)

                val request = AvatarImageRequest(
                    figure = figure,
                    size = size,
                    direction = direction,
                    headDirection = headDirection,
                    crr = crr,
                    gesture = gesture,
                    frame = frame
                )

                call.respondPng(HttpStatusCode.OK, service.getRequest(request))
            }
        }
    }
)