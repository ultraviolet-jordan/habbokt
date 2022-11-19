package com.habbokt.dao.players

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class PlayersDAOService(
    private val delegate: PlayersDAO,
    private val cache: Cache<Int, Player>
) : PlayersDAO {
    override suspend fun player(id: Int): Player? = cache[id] ?: delegate.player(id)?.also { cache.put(id, it) }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String,
        ssoTicket: String
    ): Player? = delegate.createPlayer(
        username,
        password,
        email,
        appearance,
        gender,
        ssoTicket
    )?.also { cache.put(it.id, it) }

    override suspend fun editPlayer(player: Player): Boolean {
        cache.put(player.id, player)
        return delegate.editPlayer(player)
    }

    override suspend fun deletePlayer(id: Int): Boolean {
        cache.remove(id)
        return delegate.deletePlayer(id)
    }

    override suspend fun exists(username: String): Boolean = getId(username) != null
    override suspend fun getId(username: String): Int? = cache.firstOrNull { it.value.username == username }?.value?.id ?: delegate.getId(username)
}
