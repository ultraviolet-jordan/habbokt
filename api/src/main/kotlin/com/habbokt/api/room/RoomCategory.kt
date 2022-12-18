package com.habbokt.api.room

/**
 * @author Jordan Abraham
 */
data class RoomCategory(
    val id: Int,
    val parentId: Int,
    val name: String,
    val public: Boolean,
    val rooms: List<Room>
)