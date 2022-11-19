package com.habbokt.web.plugin.koin.argon2

import de.mkammerer.argon2.Argon2Factory
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
val Argon2Module = module(createdAtStart = true) {
    single { Argon2Factory.create() }
}
