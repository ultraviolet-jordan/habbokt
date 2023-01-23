package com.habbokt.game

import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

/**
 * @author Jordan Abraham
 */
@Singleton
class GameThreadExecutorProvider : Provider<ScheduledExecutorService> {
    override fun get(): ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
}