package com.habbokt.dao.players

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class PlayerDAO(
    val id: Int,
    val name: String,
    val password: String,
    val email: String,
    val figure: String,
    val sex: String,
    val ssoTicket: String,
    val motto: String
) : Serializable