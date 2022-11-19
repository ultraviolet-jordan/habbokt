package com.habbokt.dao.players

/**
 * @author Jordan Abraham
 */
interface PlayersService {
    suspend fun player(id: Int): PlayerDAO?

    suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String,
        ssoTicket: String
    ): PlayerDAO?

    suspend fun editPlayer(
        playerDAO: PlayerDAO
    ): Boolean

    suspend fun deletePlayer(id: Int): Boolean
    suspend fun exists(username: String): Boolean
    suspend fun getId(username: String): Int?
    suspend fun ssoTicket(ssoTicket: String): PlayerDAO?
}
