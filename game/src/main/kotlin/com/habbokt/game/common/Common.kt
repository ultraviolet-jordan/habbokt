package com.habbokt.game.common

import java.security.SecureRandom

/**
 * @author Jordan Abraham
 */
private val numbers = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')

fun uuid(length: Int) = buildString {
    repeat(length) {
        append(numbers[SecureRandom().nextInt(numbers.size)].toString())
    }
}