package com.habbokt.dao.players

/**
 * @author Jordan Abraham
 */
interface PlayersService {
    suspend fun player(id: Int): PlayerDAO?

    suspend fun createPlayer(
        name: String,
        password: String,
        email: String,
        figure: String,
        sex: String,
        ssoTicket: String,
        motto: String
    ): PlayerDAO?

    suspend fun editPlayer(
        playerDAO: PlayerDAO
    ): Boolean

    suspend fun deletePlayer(id: Int): Boolean
    suspend fun exists(name: String): Boolean
    suspend fun getId(name: String): Int?
    suspend fun ssoTicket(ssoTicket: String): PlayerDAO?
}