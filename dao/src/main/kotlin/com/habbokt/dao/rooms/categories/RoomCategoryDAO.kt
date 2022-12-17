package com.habbokt.dao.rooms.categories

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class RoomCategoryDAO(
    val id: Int,
    val parentRoomId: Int,
    val name: String
) : Serializable