package com.habbokt.game

import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.network.selector.SelectorManager
import java.util.concurrent.Executors
import kotlinx.coroutines.asCoroutineDispatcher

/**
 * @author Jordan Abraham
 */
@Singleton
class ServerSocketSelectorProvider : Provider<SelectorManager> {
    override fun get(): SelectorManager = SelectorManager(Executors.newCachedThreadPool().asCoroutineDispatcher())
}