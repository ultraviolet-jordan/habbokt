package com.habbokt.web.dao.players

/**
 * @author Jordan Abraham
 */
interface PlayersDAO {
    suspend fun player(username: String): Player?

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

    suspend fun deletePlayer(username: String): Boolean

    suspend fun exists(username: String): Boolean

    suspend fun getId(username: String): Int?
}
