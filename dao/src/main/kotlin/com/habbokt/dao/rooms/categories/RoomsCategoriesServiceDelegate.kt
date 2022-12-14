package com.habbokt.dao.rooms.categories

import com.google.inject.Singleton
import com.habbokt.db.query
import com.habbokt.db.rooms.categories.RoomsCategoriesTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomsCategoriesServiceDelegate : RoomsCategoriesService {
    override suspend fun roomCategory(id: Int): RoomCategoryDAO? = query {
        RoomsCategoriesTable
            .select { RoomsCategoriesTable.id eq id }
            .map(::resultToRoomCategory)
            .singleOrNull()
    }

    override suspend fun createRoomCategory(
        id: Int,
        parentId: Int,
        name: String
    ): RoomCategoryDAO? = query {
        RoomsCategoriesTable.insert {
            it[RoomsCategoriesTable.id] = id
            it[RoomsCategoriesTable.parentId] = parentId
            it[RoomsCategoriesTable.name] = name
        }.resultedValues?.singleOrNull()?.let(::resultToRoomCategory)
    }

    override suspend fun editRoomCategory(roomCategoryDAO: RoomCategoryDAO): Boolean = query {
        RoomsCategoriesTable.update({ RoomsCategoriesTable.id eq roomCategoryDAO.id }) {
            it[id] = roomCategoryDAO.id
            it[parentId] = roomCategoryDAO.parentId
            it[name] = roomCategoryDAO.name
        } > 0
    }

    override suspend fun deleteRoomCategory(id: Int): Boolean = query {
        RoomsCategoriesTable.deleteWhere { RoomsCategoriesTable.id eq id } > 0
    }

    override suspend fun subCategories(id: Int): List<RoomCategoryDAO> = query {
        RoomsCategoriesTable
            .select { RoomsCategoriesTable.parentId eq id }
            .map(::resultToRoomCategory)
    }

    private fun resultToRoomCategory(row: ResultRow) = RoomCategoryDAO(
        id = row[RoomsCategoriesTable.id],
        parentId = row[RoomsCategoriesTable.parentId],
        name = row[RoomsCategoriesTable.name]
    )
}