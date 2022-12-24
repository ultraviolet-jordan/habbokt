package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.ApplicationEngineEnvironment
import io.ktor.server.engine.loadCommonConfiguration
import io.ktor.server.netty.NettyApplicationEngine

/**
 * @author Jordan Abraham
 */
@Singleton
class ApplicationEngineProvider @Inject constructor(
    private val applicationEnvironment: ApplicationEnvironment
) : Provider<NettyApplicationEngine> {
    override fun get(): NettyApplicationEngine = NettyApplicationEngine(applicationEnvironment as ApplicationEngineEnvironment) { loadCommonConfiguration(applicationEnvironment.config) }
}