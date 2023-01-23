package com.habbokt.game

import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.concurrent.Executors

/**
 * @author Jordan Abraham
 */
@Singleton
class GameThreadProvider : Provider<GameThread> {
    override fun get(): GameThread = GameThread(executor = Executors.newSingleThreadScheduledExecutor())
}