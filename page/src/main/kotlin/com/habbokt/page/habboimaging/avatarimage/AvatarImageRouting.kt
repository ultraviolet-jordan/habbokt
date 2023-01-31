package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
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
                service.getRequest(call)
            }
        }
    }
)