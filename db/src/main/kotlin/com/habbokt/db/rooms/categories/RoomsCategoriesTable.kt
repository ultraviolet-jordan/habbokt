package com.habbokt.db.rooms.categories

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object RoomsCategoriesTable : Table() {
    val id = integer("id")
    val parentId = integer("parent_id")
    val name = text("name")

    override val primaryKey = PrimaryKey(id)
}