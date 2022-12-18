package com.habbokt.dao.rooms

/**
 * @author Jordan Abraham
 */
interface RoomsService {
    suspend fun room(id: Int): RoomDAO?

    suspend fun createRoom(
        categoryId: Int,
        name: String,
        description: String,
        swfCast: String,
        model: String
    ): RoomDAO?

    suspend fun editRoom(roomDAO: RoomDAO): Boolean
    suspend fun deleteRoom(id: Int): Boolean
    suspend fun roomsByCategoryId(categoryId: Int): List<RoomDAO>
}