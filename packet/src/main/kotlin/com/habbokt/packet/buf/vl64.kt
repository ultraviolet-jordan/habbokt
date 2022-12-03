package com.habbokt.packet.buf

import kotlin.math.abs

/**
 * @author Jordan Abraham
 */
fun Int.vl64(): ByteArray = vl64TailRec()
fun ByteArray.vl64(): Int = vl64TailRec()

private tailrec fun Int.vl64TailRec(
    size: Int = 1,
    absoluteValue: Int = abs(this) shr 2,
    result: ByteArray = ByteArray(size = 6).apply { this[0] = (64 + (abs(this@vl64TailRec) and 3)).toByte() }
): ByteArray {
    if (absoluteValue == 0) {
        return result.apply {
            this[0] = (this[0].toInt() or (size shl 3) or if (this@vl64TailRec >= 0) 0 else 4).toByte()
        }.copyInto(
            destination = ByteArray(size),
            destinationOffset = 0,
            startIndex = 0,
            endIndex = size
        )
    }
    return vl64TailRec(
        size = size + 1,
        absoluteValue = absoluteValue shr 6,
        result = result.apply { this[size] = (64 + (absoluteValue and 0x3f)).toByte() }
    )
}

private tailrec fun ByteArray.vl64TailRec(
    result: Int = this[0].toInt() and 3,
    shiftAmount: Int = 2,
    position: Int = 1
): Int {
    if (position == this[0].toInt() shr 3 and 7) return if (this[0].toInt() and 4 == 4) -result else result
    return vl64TailRec(
        result = result or (this[position].toInt() and 0x3f shl shiftAmount),
        shiftAmount = 2 + 6 * position,
        position = position + 1
    )
}