package com.habbokt.dao.players

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class Player(
    val id: Int,
    val username: String,
    val password: String,
    val email: String,
    val appearance: String,
    val gender: String
) : Serializable