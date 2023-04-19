package com.habbokt.packet.buf

import java.nio.ByteBuffer
import kotlin.math.abs

/**
 * @author Jordan Abraham
 */
fun ByteBuffer.putPacketId(value: Int): ByteBuffer = putAsBase64(value)

fun ByteBuffer.putIntHabbo(value: Int): ByteBuffer = putAsVl64(value.toLong())
fun ByteBuffer.putLongHabbo(value: Long): ByteBuffer = putAsVl64(value)

fun ByteBuffer.putStringHabbo(value: String): ByteBuffer {
    for (char in value) {
        put(char.code.toByte())
    }
    put(2)
    return this
}

fun ByteBuffer.putString(value: String): ByteBuffer {
    for (char in value) {
        put(char.code.toByte())
    }
    return this
}

private tailrec fun ByteBuffer.putAsBase64(
    value: Int,
    index: Int = 0
): ByteBuffer {
    // Put 2 bytes into the buffer only.
    if (index == 2) return this
    put((((value shr 6 * (1 - index)) and 0x3F) + 64).toByte())
    return putAsBase64(value, index + 1)
}

private tailrec fun ByteBuffer.putAsVl64(
    value: Long,
    abs: Long = abs(value),
    prefixPosition: Int = position(), // The current position of this buffer used to track the prefix byte.
    currentPosition: Int = 1 // Current number of bytes written.
): ByteBuffer {
    if (currentPosition == 1) {
        // Set prefix byte at this current position. This is only called the first iteration.
        put((64 + (abs and 3)).toByte())
    }
    val remainingBits = (abs shr 2) shr (6 * (currentPosition - 1))
    if (remainingBits != 0L) {
        // Append a new byte to the buffer with the next 6 bits of the absolute value.
        put((64 + (remainingBits and 0x3F)).toByte())
        return putAsVl64(value, abs, prefixPosition, currentPosition + 1)
    }
    // Modify the prefix byte to include the size and sign of the integer.
    val prefix = get(prefixPosition).toInt()
    put(prefixPosition, (prefix or (currentPosition shl 3) or if (value >= 0) 0 else 4).toByte())
    return this
}