package com.habbokt.db

/**
 * @author Jordan Abraham
 */
data class DatabaseConfiguration(
    val driverClassName: String,
    val jdbcUrl: String,
    val maximumPoolSize: Int,
    val isAutoCommit: Boolean,
    val transactionIsolation: String,
    val enableConsole: Boolean
)