package com.habbokt.api.client.handshake

/**
 * @author Jordan Abraham
 */
data class LoginInformation(
    val id: Int,
    val username: String,
    val password: String,
    val email: String,
    val appearance: String,
    val gender: String
)