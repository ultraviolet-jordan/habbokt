package com.habbokt.game

import com.google.inject.Singleton
import com.habbokt.api.client.Client
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Jordan Abraham
 */
@Singleton
class ConnectionPool : MutableSet<Client> by ConcurrentHashMap.newKeySet() {
    /**
     * This property is to check if this connection pool is accepting new connections or not.
     */
    var closed = false
        private set

    /**
     * Close all clients inside of this connection pool and set the accepting to false so this pool no longer accepts connections.
     */
    fun dropAllAndCloseAndClear() {
        onEach(Client::close)
            .also { closed = true }
            .clear()
    }
}