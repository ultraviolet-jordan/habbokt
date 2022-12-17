package com.habbokt.api.server

import com.habbokt.api.client.ConnectionPool

/**
 * @author Jordan Abraham
 */
interface Server {
    fun bind()
    fun connectionPool(): ConnectionPool<*>
}