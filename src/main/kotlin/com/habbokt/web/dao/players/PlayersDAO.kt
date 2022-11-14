package com.habbokt.web.dao

import com.habbokt.web.dao.model.Player

/**
 * @author Jordan Abraham
 */
interface DAOFacade {
    suspend fun player(id: Int): Player?

    suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Player?

    suspend fun editPlayer(
        id: Int,
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Boolean

    suspend fun deletePlayer(id: Int): Boolean
}
