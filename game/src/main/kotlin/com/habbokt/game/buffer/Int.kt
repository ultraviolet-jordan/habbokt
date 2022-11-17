package com.habbokt.game.buffer

import kotlin.math.abs

/**
 * @author Jordan Abraham
 */
fun Int.base64(size: Int): ByteArray = ByteArray(size) { (((this shr 6 * (size - 1 - it)) and 0x3f) + 0x40).toByte() }

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