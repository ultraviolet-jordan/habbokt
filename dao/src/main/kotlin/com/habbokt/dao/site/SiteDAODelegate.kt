package com.habbokt.dao.site

import com.habbokt.dao.DatabaseFactory.query
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

/**
 * @author Jordan Abraham
 */
class SiteDAODelegate : SiteDAO {
    override suspend fun site(): Site = query {
        SiteTable
            .select { SiteTable.id eq 1 }
            .map(::resultToSite)
            .single()
    }

    override suspend fun createSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: String,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Site? = query {
        SiteTable.insert {
            it[SiteTable.siteName] = siteName
            it[SiteTable.staticContentPath] = staticContentPath
            it[SiteTable.serverOnline] = serverOnline
            it[SiteTable.loaderGameIp] = loaderGameIp
            it[SiteTable.loaderGamePort] = loaderGamePort
            it[SiteTable.loaderDcr] = loaderDcr
            it[SiteTable.loaderVariables] = loaderVariables
            it[SiteTable.loaderTexts] = loaderTexts
        }.resultedValues?.singleOrNull()?.let(::resultToSite)
    }

    override suspend fun editSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: String,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Boolean = query {
        SiteTable.update({ SiteTable.id eq 1 }) {
            it[SiteTable.siteName] = siteName
            it[SiteTable.staticContentPath] = staticContentPath
            it[SiteTable.serverOnline] = serverOnline
            it[SiteTable.loaderGameIp] = loaderGameIp
            it[SiteTable.loaderGamePort] = loaderGamePort
            it[SiteTable.loaderDcr] = loaderDcr
            it[SiteTable.loaderVariables] = loaderVariables
            it[SiteTable.loaderTexts] = loaderTexts
        } > 0
    }

    private fun resultToSite(row: ResultRow) = Site(
        siteName = row[SiteTable.siteName],
        staticContentPath = row[SiteTable.staticContentPath],
        serverOnline = row[SiteTable.serverOnline],
        loaderGameIp = row[SiteTable.loaderGameIp],
        loaderGamePort = row[SiteTable.loaderGamePort],
        loaderDcr = row[SiteTable.loaderDcr],
        loaderVariables = row[SiteTable.loaderVariables],
        loaderTexts = row[SiteTable.loaderTexts]
    )
}
