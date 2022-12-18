package com.habbokt.dao.rooms.categories

/**
 * @author Jordan Abraham
 */
interface RoomsCategoriesService {
    suspend fun roomCategory(id: Int): RoomCategoryDAO?

    suspend fun createRoomCategory(
        id: Int,
        parentId: Int,
        name: String
    ): RoomCategoryDAO?

    suspend fun editRoomCategory(roomCategoryDAO: RoomCategoryDAO): Boolean
    suspend fun deleteRoomCategory(id: Int): Boolean
    suspend fun subCategories(id: Int): List<RoomCategoryDAO>
}