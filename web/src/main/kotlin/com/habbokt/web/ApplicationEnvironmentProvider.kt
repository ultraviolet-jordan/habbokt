package com.habbokt.web

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.server.application.ApplicationEnvironment
import io.ktor.server.engine.commandLineEnvironment

/**
 * @author Jordan Abraham
 */
@Singleton
class ApplicationEnvironmentProvider @Inject constructor(
    private val args: Array<String>
) : Provider<ApplicationEnvironment> {
    override fun get(): ApplicationEnvironment = commandLineEnvironment(args)
}