package com.habbokt.dao.site

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class SiteServiceEhcache(
    private val delegate: SiteService,
    private val cache: Cache<Int, SiteDAO>
) : SiteService {
    override suspend fun site(): SiteDAO = cache[1] ?: delegate.site().also { cache.put(1, it) }

    override suspend fun createSite(siteDAO: SiteDAO): SiteDAO? = delegate.createSite(siteDAO)?.also { cache.put(1, it) }

    override suspend fun editSite(siteDAO: SiteDAO): Boolean {
        cache.put(1, siteDAO)
        return delegate.editSite(siteDAO)
    }
}
