package com.habbokt.web.dao.model

import org.jetbrains.exposed.sql.Table
import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class Player(
    val id: Int,
    val username: String,
    val password: String,
    val email: String,
    val appearance: String,
    val gender: String
) : Serializable

object Players : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = text("password")
    val email = varchar("email", 255)
    val appearance = varchar("appearance", 255)
    val gender = char("gender", 1)

    override val primaryKey = PrimaryKey(id)
}
