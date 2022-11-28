package com.habbokt.api.common

import java.security.SecureRandom

/**
 * @author Jordan Abraham
 */
object Common {
    private val numbers = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')

    fun uuid(length: Int): String {
        return buildString {
            repeat(length) {
                append(numbers[SecureRandom().nextInt(numbers.size)].toString())
            }
        }
    }
}