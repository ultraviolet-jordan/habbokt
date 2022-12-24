package com.habbokt.db

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HikariDataSourceProvider @Inject constructor(
    private val hikariConfig: HikariConfig
): Provider<HikariDataSource> {
    override fun get(): HikariDataSource = HikariDataSource(hikariConfig)
}