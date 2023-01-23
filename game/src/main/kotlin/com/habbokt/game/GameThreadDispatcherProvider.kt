package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.server.application.ApplicationEnvironment
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
@Singleton
class GameThreadDispatcherProvider @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment
) : Provider<GameThreadDispatcher> {
    override fun get(): GameThreadDispatcher = GameThreadDispatcher(
        forkJoinPool = ForkJoinPool(applicationEnvironment.config.property("game.cores").getString().toInt())
    )
}