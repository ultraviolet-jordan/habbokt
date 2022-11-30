package com.habbokt.api.entity.player

/**
 * @author Jordan Abraham
 */
data class PlayerDetails(
    val id: Int,
    val username: String,
    val password: String,
    val email: String,
    val appearance: String,
    val gender: String
)