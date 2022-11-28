package com.habbokt.argon2

import de.mkammerer.argon2.Argon2
import de.mkammerer.argon2.Argon2Factory
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
object Argon2Module : KotlinModule() {
    override fun configure() {
        bind<Argon2>().toInstance(Argon2Factory.create())
    }
}