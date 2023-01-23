package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.server.application.ApplicationEnvironment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
@Singleton
class GameThreadDispatcherProvider @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment
) : Provider<CoroutineDispatcher> {
    override fun get(): CoroutineDispatcher = ForkJoinPool(applicationEnvironment.config.property("game.cores").getString().toInt()).asCoroutineDispatcher()
}