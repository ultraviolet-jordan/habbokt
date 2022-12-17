package com.habbokt.dao.rooms

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class RoomDAO(
    val id: Int,
    val categoryId: Int,
    val name: String
) : Serializable