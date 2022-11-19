package com.habbokt.dao.site

/**
 * @author Jordan Abraham
 */
interface SiteDAO {
    suspend fun site(): Site
    suspend fun createSite(site: Site): Site?
    suspend fun editSite(site: Site): Boolean
}
