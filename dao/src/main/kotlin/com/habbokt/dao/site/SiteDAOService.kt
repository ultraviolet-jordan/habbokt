package com.habbokt.dao.site

import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
class SiteDAOService(
    private val delegate: SiteDAO,
    private val cache: Cache<Int, Site>
) : SiteDAO {
    override suspend fun site(): Site = cache[1] ?: delegate.site().also { cache.put(1, it) }

    override suspend fun createSite(site: Site): Site? = delegate.createSite(site)?.also { cache.put(1, it) }

    override suspend fun editSite(site: Site): Boolean {
        cache.put(1, site)
        return delegate.editSite(site)
    }
}
