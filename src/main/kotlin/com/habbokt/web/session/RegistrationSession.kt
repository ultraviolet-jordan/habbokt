package com.habbokt.web.session

import io.ktor.server.auth.Principal

/**
 * @author Jordan Abraham
 */
data class RegistrationSession(
    val username: String,
    val password: String,
    val email: String,
    val birthDay: String,
    val birthMonth: String,
    val birthYear: String,
    val appearance: String,
    val gender: String
) : Principal
