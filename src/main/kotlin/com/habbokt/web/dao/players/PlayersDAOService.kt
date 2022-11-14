package com.habbokt.web.dao.players

import com.habbokt.web.dao.persistence.CachingAliases
import com.habbokt.web.dao.persistence.buildCacheManager

/**
 * @author Jordan Abraham
 */
class PlayersDAOCacheService(
    private val delegate: PlayersDAO,
) : PlayersDAO {
    private val cache = buildCacheManager(
        alias = CachingAliases.PlayersTableCache,
        type = Player::class
    ).getCache(CachingAliases.PlayersTableCache, Int::class.javaObjectType, Player::class.java)
    override suspend fun player(id: Int): Player? = cache[id] ?: delegate.player(id).also { cache.put(id, it) }

    override suspend fun createPlayer(
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Player? = delegate.createPlayer(username, password, email, appearance, gender)?.also { cache.put(it.id, it) }

    override suspend fun editPlayer(
        id: Int,
        username: String,
        password: String,
        email: String,
        appearance: String,
        gender: String
    ): Boolean {
        cache.put(id, Player(id, username, password, email, appearance, gender))
        return delegate.editPlayer(id, username, password, email, appearance, gender)
    }

    override suspend fun deletePlayer(id: Int): Boolean {
        cache.remove(id)
        return delegate.deletePlayer(id)
    }

    override suspend fun exists(id: Int): Boolean = player(id) != null
}
