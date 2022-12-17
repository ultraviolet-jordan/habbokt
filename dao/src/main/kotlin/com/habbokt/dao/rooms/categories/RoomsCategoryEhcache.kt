package com.habbokt.dao.rooms.categories

import com.google.inject.Inject
import com.google.inject.Singleton
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomsCategoryEhcache @Inject constructor(
    private val delegate: RoomsCategoryDelegate,
    private val cache: Cache<Int, RoomCategoryDAO>
) : RoomsCategoriesService {
    override suspend fun roomCategory(id: Int): RoomCategoryDAO? = cache[id] ?: delegate.roomCategory(id)?.also { cache.put(id, it) }

    override suspend fun createRoomCategory(
        roomId: Int,
        parentRoomId: Int,
        name: String
    ): RoomCategoryDAO? = delegate.createRoomCategory(
        roomId,
        parentRoomId,
        name
    )?.also { cache.put(it.id, it) }

    override suspend fun editRoomCategory(roomCategoryDAO: RoomCategoryDAO): Boolean {
        cache.put(roomCategoryDAO.id, roomCategoryDAO)
        return delegate.editRoomCategory(roomCategoryDAO)
    }

    override suspend fun deleteRoomCategory(id: Int): Boolean {
        cache.remove(id)
        return delegate.deleteRoomCategory(id)
    }
}