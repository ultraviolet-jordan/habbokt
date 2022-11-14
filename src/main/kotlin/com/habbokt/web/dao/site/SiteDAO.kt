package com.habbokt.web.dao.site

/**
 * @author Jordan Abraham
 */
interface SiteDAO {
    suspend fun site(): Site

    suspend fun createSite(
        siteName: String,
        staticContentPath: String
    ): Site?

    suspend fun editSite(
        siteName: String,
        staticContentPath: String
    ): Boolean
}
