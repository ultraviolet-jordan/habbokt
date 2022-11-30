package com.habbokt.dao.players

import com.google.inject.Inject
import com.google.inject.Singleton
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
@Singleton
class PlayersServiceEhcache @Inject constructor(
    private val delegate: PlayersServiceDelegate,
    private val cache: Cache<Int, PlayerDAO>
) : PlayersService {
    override suspend fun player(id: Int): PlayerDAO? = cache[id] ?: delegate.player(id)?.also { cache.put(id, it) }

    override suspend fun createPlayer(
        name: String,
        password: String,
        email: String,
        figure: String,
        sex: String,
        ssoTicket: String,
        motto: String
    ): PlayerDAO? = delegate.createPlayer(
        name,
        password,
        email,
        figure,
        sex,
        ssoTicket,
        motto
    )?.also { cache.put(it.id, it) }

    override suspend fun editPlayer(playerDAO: PlayerDAO): Boolean {
        cache.put(playerDAO.id, playerDAO)
        return delegate.editPlayer(playerDAO)
    }

    override suspend fun deletePlayer(id: Int): Boolean {
        cache.remove(id)
        return delegate.deletePlayer(id)
    }

    override suspend fun exists(name: String): Boolean = getId(name) != null
    override suspend fun getId(name: String): Int? = cache.firstOrNull { it.value.name == name }?.value?.id ?: delegate.getId(name)
    override suspend fun ssoTicket(ssoTicket: String): PlayerDAO? = cache.firstOrNull { it.value.ssoTicket == ssoTicket }?.value ?: delegate.ssoTicket(ssoTicket)
}