package com.habbokt.db.rooms

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object RoomsTable : Table() {
    val id = integer("id").autoIncrement()
    val categoryId = integer("category_id")
    val name = text("name")
    val description = text("description")

    override val primaryKey = PrimaryKey(id)
}