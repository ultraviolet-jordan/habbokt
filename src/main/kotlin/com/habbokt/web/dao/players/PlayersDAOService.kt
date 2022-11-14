package com.habbokt.web.dao.players

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class PlayersDAOService(
    private val delegate: PlayersDAO,
    private val cache: Cache<String, Player>
) : PlayersDAO {
    override suspend fun player(username: String): Player? = cache[username] ?: delegate.player(username)?.also { cache.put(username, it) }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Player? = delegate.createPlayer(username, password, email, appearance, gender)?.also { cache.put(username, it) }

    override suspend fun editPlayer(
        id: Int,
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Boolean {
        cache.put(username, Player(id, username, password, email, appearance, gender))
        return delegate.editPlayer(id, username, password, email, appearance, gender)
    }

    override suspend fun deletePlayer(username: String): Boolean {
        cache.remove(username)
        return delegate.deletePlayer(username)
    }

    override suspend fun exists(username: String): Boolean = getId(username) != null
    override suspend fun getId(username: String): Int? = cache[username]?.id ?: delegate.getId(username)
}
