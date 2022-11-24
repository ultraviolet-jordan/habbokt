package com.habbokt.session

import io.ktor.server.auth.Principal

/**
 * @author Jordan Abraham
 */
data class UserSession(
    val authenticated: Boolean,
    val userId: String
) : Principal