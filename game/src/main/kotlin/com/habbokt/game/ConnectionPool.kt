package com.habbokt.game

import com.google.inject.Singleton
import com.habbokt.api.client.Client
import io.ktor.util.collections.ConcurrentSet

/**
 * @author Jordan Abraham
 */
@Singleton
class ConnectionPool : MutableSet<Client> by ConcurrentSet()