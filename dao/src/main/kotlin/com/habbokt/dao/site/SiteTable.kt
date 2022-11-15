package com.habbokt.dao.site

import org.jetbrains.exposed.sql.Table

/**
 * @author Jordan Abraham
 */
object SiteTable : Table() {
    val id = integer("id").default(1)
    val siteName = varchar("siteName", 25)
    val staticContentPath = text("staticContentPath")
    val serverOnline = bool("serverOnline")
    val loaderGameIp = varchar("loaderGameIp", 15)
    val loaderGamePort = varchar("loaderGamePort", 5)
    val loaderDcr = varchar("loaderDcr", 128)
    val loaderVariables = varchar("loaderVariables", 128)
    val loaderTexts = varchar("loaderTexts", 128)

    override val primaryKey = PrimaryKey(id)
}
