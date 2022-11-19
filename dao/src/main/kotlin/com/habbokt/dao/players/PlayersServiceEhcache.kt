package com.habbokt.dao.players

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class PlayersServiceEhcache(
    private val delegate: PlayersService,
    private val cache: Cache<Int, PlayerDAO>
) : PlayersService {
    override suspend fun player(id: Int): PlayerDAO? = cache[id] ?: delegate.player(id)?.also { cache.put(id, it) }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String,
        ssoTicket: String
    ): PlayerDAO? = delegate.createPlayer(
        username,
        password,
        email,
        appearance,
        gender,
        ssoTicket
    )?.also { cache.put(it.id, it) }

    override suspend fun editPlayer(playerDAO: PlayerDAO): Boolean {
        cache.put(playerDAO.id, playerDAO)
        return delegate.editPlayer(playerDAO)
    }

    override suspend fun deletePlayer(id: Int): Boolean {
        cache.remove(id)
        return delegate.deletePlayer(id)
    }

    override suspend fun exists(username: String): Boolean = getId(username) != null
    override suspend fun getId(username: String): Int? = cache.firstOrNull { it.value.username == username }?.value?.id ?: delegate.getId(username)
}
