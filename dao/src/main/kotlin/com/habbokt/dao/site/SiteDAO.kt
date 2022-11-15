package com.habbokt.dao.site

/**
 * @author Jordan Abraham
 */
interface SiteDAO {
    suspend fun site(): Site

    suspend fun createSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean
    ): Site?

    suspend fun editSite(
        siteName: String,
        staticContentPath: String,
        serverOnline: Boolean
    ): Boolean
}
