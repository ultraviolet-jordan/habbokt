package com.habbokt.game.buffer

/**
 * @author Jordan Abraham
 */
fun ByteArray.base64(): Int = foldIndexed(0) { index, sum, x -> sum + ((x - 0x40) shl 6 * (size - 1 - index)) }

fun ByteArray.vl64(): Int {
    val negative = this[0].toInt() and 4 == 4
    val size = this[0].toInt() shr 3 and 7

    var result = this[0].toInt() and 3

    var shiftAmount = 2

    for (b in 1 until size) {
        result = result or (this[b].toInt() and 0x3f shl shiftAmount)
        shiftAmount = 2 + 6 * b
    }

    return if (negative) -result else result
}
