package com.habbokt.argon2

import com.google.inject.Inject
import com.google.inject.Singleton
import de.mkammerer.argon2.Argon2

/**
 * @author Jordan Abraham
 */
@Singleton
class Argon2Service @Inject constructor(
    private val argon2: Argon2
) {
    fun hash(
        iterations: Int,
        memory: Int,
        parallelism: Int,
        data: ByteArray?
    ): String? = argon2.hash(iterations, memory, parallelism, data)
}