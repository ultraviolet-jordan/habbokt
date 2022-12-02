package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Provider
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationEnvironment

/**
 * @author Jordan Abraham
 */
class ApplicationEnvironmentProvider @Inject constructor(
    private val application: Application
) : Provider<ApplicationEnvironment> {
    override fun get(): ApplicationEnvironment = application.environment
}