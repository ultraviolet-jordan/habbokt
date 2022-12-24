package com.habbokt.db

/**
 * @author Jordan Abraham
 */
internal interface DatabaseConnection {
    fun connect()
    fun createTables()
    fun close()
}