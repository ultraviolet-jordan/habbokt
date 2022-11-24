package com.habbokt.dao.site

/**
 * @author Jordan Abraham
 */
interface SiteService {
    suspend fun site(): SiteDAO
    suspend fun createSite(siteDAO: SiteDAO): SiteDAO?
    suspend fun editSite(siteDAO: SiteDAO): Boolean
}