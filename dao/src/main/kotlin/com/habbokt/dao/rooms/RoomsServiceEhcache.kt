package com.habbokt.dao.rooms

import com.google.inject.Inject
import com.google.inject.Singleton
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomsServiceEhcache @Inject constructor(
    private val delegate: RoomsServiceDelegate,
    private val cache: Cache<Int, RoomDAO>
) : RoomsService {
    override suspend fun room(id: Int): RoomDAO? = cache[id] ?: delegate.room(id)?.also { cache.put(id, it) }

    override suspend fun createRoom(
        categoryId: Int,
        name: String
    ): RoomDAO? = delegate.createRoom(
        categoryId,
        name
    )?.also { cache.put(it.id, it) }

    override suspend fun editRoom(roomDAO: RoomDAO): Boolean {
        cache.put(roomDAO.id, roomDAO)
        return delegate.editRoom(roomDAO)
    }

    override suspend fun deleteRoom(id: Int): Boolean {
        cache.remove(id)
        return delegate.deleteRoom(id)
    }

    override suspend fun roomsByCategoryId(categoryId: Int): List<RoomDAO> = delegate.roomsByCategoryId(categoryId)
}