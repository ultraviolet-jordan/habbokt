package com.habbokt.dao.players

/**
 * @author Jordan Abraham
 */
interface PlayersDAO {
    suspend fun player(id: Int): Player?

    suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String,
        ssoTicket: String
    ): Player?

    suspend fun editPlayer(
        player: Player
    ): Boolean

    suspend fun deletePlayer(id: Int): Boolean

    suspend fun exists(username: String): Boolean

    suspend fun getId(username: String): Int?
}
