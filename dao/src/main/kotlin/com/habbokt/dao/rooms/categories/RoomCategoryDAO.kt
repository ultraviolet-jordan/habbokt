package com.habbokt.dao.rooms.categories

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class RoomCategoryDAO(
    val id: Int,
    val parentId: Int,
    val name: String
) : Serializable