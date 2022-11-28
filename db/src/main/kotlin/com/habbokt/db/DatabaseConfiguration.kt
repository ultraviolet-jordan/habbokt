package com.habbokt.db

/**
 * @author Jordan Abraham
 */
data class DatabaseConfiguration(
    var driverClassName: String? = null,
    var jdbcUrl: String? = null,
    var maximumPoolSize: Int? = null,
    var isAutoCommit: Boolean? = null,
    var transactionIsolation: String? = null,
    var enableConsole: Boolean? = null
)