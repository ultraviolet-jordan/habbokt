package com.habbokt.dao.site

/**
 * @author Jordan Abraham
 */
interface SiteDAO {
    suspend fun site(): Site

    suspend fun createSite(
        siteName: String,
        sitePath: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: Int,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Site?

    suspend fun editSite(
        siteName: String,
        sitePath: String,
        staticContentPath: String,
        serverOnline: Boolean,
        loaderGameIp: String,
        loaderGamePort: Int,
        loaderDcr: String,
        loaderVariables: String,
        loaderTexts: String
    ): Boolean
}
