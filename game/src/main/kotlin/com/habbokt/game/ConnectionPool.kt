package com.habbokt.game

import com.google.inject.Singleton
import com.habbokt.api.client.Client
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Jordan Abraham
 */
@Singleton
class ConnectionPool : MutableSet<Client> by ConcurrentHashMap.newKeySet() {
    private var accepting = true
    fun dropAll(): ConnectionPool = onEach(Client::close).also { accepting = false }
    fun accepting(): Boolean = accepting
}