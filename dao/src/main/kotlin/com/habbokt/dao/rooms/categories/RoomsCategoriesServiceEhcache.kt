package com.habbokt.dao.rooms.categories

import com.google.inject.Inject
import com.google.inject.Singleton
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomsCategoriesServiceEhcache @Inject constructor(
    private val delegate: RoomsCategoriesServiceDelegate,
    private val cache: Cache<Int, RoomCategoryDAO>
) : RoomsCategoriesService {
    override suspend fun roomCategory(id: Int): RoomCategoryDAO? = cache[id] ?: delegate.roomCategory(id)?.also { cache.put(id, it) }

    override suspend fun createRoomCategory(
        id: Int,
        parentId: Int,
        name: String
    ): RoomCategoryDAO? = delegate.createRoomCategory(
        id,
        parentId,
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

    override suspend fun subCategories(id: Int): List<RoomCategoryDAO> = delegate.subCategories(id)
}