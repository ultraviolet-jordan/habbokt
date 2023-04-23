package com.habbokt.game

import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.network.selector.SelectorManager
import kotlinx.coroutines.Dispatchers

/**
 * @author Jordan Abraham
 */
@Singleton
class ServerSocketSelectorProvider : Provider<SelectorManager> {
    override fun get(): SelectorManager = SelectorManager(Dispatchers.IO)
}