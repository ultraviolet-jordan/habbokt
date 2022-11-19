package com.habbokt.web.session

import io.ktor.server.auth.Principal

/**
 * @author Jordan Abraham
 */
data class UserSession(
    val authenticated: Boolean,
    val playerId: String
) : Principal
