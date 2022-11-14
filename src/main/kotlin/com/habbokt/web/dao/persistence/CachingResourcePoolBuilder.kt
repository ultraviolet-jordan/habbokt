package com.habbokt.web.dao.persistence

import java.io.File
import java.lang.Exception
import org.ehcache.Cache
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.CacheManagerBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.ehcache.config.units.EntryUnit
import org.ehcache.config.units.MemoryUnit
import org.ehcache.impl.config.persistence.CacheManagerPersistenceConfiguration

/**
 * @author Jordan Abraham
 */
fun <T> buildCacheResourcePool(alias: String, type: Class<T>): Cache<Int, T> = try {
    CacheManagerBuilder.newCacheManagerBuilder()
        // TODO Probably move this path out.
        .with(CacheManagerPersistenceConfiguration(File("build/ehcache")))
        .withCache(
            alias,
            CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Int::class.javaObjectType,
                type,
                ResourcePoolsBuilder.newResourcePoolsBuilder()
                    .heap(1000, EntryUnit.ENTRIES)
                    .offheap(10, MemoryUnit.MB)
                    .disk(100, MemoryUnit.MB, true)
            )
        )
        .build(true)
        .getCache(alias, Int::class.javaObjectType, type)
} catch (exception: Exception) {
    throw RuntimeException("")
}