package com.habbokt.web.dao.site

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object SiteTable : Table() {
    val id = integer("id").default(1)
    val siteName = varchar("siteName", 15)
    val staticContentPath = text("staticContentPath")
    val serverOnline = bool("serverOnline")

    override val primaryKey = PrimaryKey(id)
}
