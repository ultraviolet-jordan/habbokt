package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.client.ConnectionPool
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Jordan Abraham
 */
class GameClientPool : ConnectionPool<Client> {
    private val clients = ConcurrentHashMap<String, Client>()

    override fun add(type: Client): Boolean {
        val socketAddress = type.socketAddress().toString()
        clients[socketAddress] = type
        return clients[socketAddress] == type
    }

    override fun drop(type: Client): Boolean {
        val removed = clients.remove(type.socketAddress().toString())
        return !clients.containsKey(removed?.socketAddress()?.toString())
    }

    override fun collect(): List<Client> = clients.values.filter(Client::connected).toList()
}