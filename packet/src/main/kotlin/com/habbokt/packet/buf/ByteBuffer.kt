package com.habbokt.packet.buf

import java.nio.ByteBuffer
import kotlin.math.abs

/**
 * @author Jordan Abraham
 */
fun ByteBuffer.putPacketId(value: Int): ByteBuffer = putAsBase64(value)

fun ByteBuffer.putIntHabbo(value: Int): ByteBuffer = putAsVl64(value)

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

private fun ByteBuffer.putAsBase64(value: Int): ByteBuffer {
    // Put 2 bytes into the buffer only.
    for (index in 0 until 2) {
        put((((value shr 6 * (1 - index)) and 0x3F) + 64).toByte())
    }
    return this
}

private tailrec fun ByteBuffer.putAsVl64(
    value: Int,
    abs: Int = abs(value),
    position: Int = position(), // The current position of this buffer used to track the prefix byte.
    size: Int = 1 // Current number of bytes written.
): ByteBuffer {
    if (size == 1) {
        // Set prefix byte at this current position. This is only called the first iteration.
        put((64 + (abs and 3)).toByte())
    }
    val nextByte = (abs shr 2) shr (6 * (size - 1))
    if (nextByte != 0) {
        // Append a new byte to the buffer with the next 6 bits of the absolute value.
        put((64 + (nextByte and 0x3F)).toByte())
        return putAsVl64(value, abs, position, size + 1)
    }
    // Modify the prefix byte to include the size and sign of the integer.
    val prefix = get(position).toInt()
    put(position, (prefix or (size shl 3) or if (value >= 0) 0 else 4).toByte())
    return this
}