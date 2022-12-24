package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.netty.NettyApplicationEngine

/**
 * @author Jordan Abraham
 */
@Singleton
class ApplicationEnvironmentProvider @Inject constructor(
    private val applicationEngine: NettyApplicationEngine
) : Provider<ApplicationEnvironment> {
    override fun get(): ApplicationEnvironment = applicationEngine.environment
}