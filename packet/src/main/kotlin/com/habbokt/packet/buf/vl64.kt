package com.habbokt.packet.buf

import kotlin.math.abs

/**
 * @author Jordan Abraham
 */
fun Int.vl64(): ByteArray {
    val vlEncoded = ByteArray(6)

    var size = 1
    var absoluteValue = abs(this)

    vlEncoded[0] = (64 + (absoluteValue and 3)).toByte()

    absoluteValue = absoluteValue shr 2

    while (absoluteValue != 0) {
        size++
        vlEncoded[size - 1] = (64 + (absoluteValue and 0x3f)).toByte()
        absoluteValue = absoluteValue shr 6
    }

    vlEncoded[0] = (vlEncoded[0].toInt() or (size shl 3) or if (this >= 0) 0 else 4).toByte()

    return ByteArray(size).apply {
        System.arraycopy(vlEncoded, 0, this, 0, size)
    }
}

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