package com.habbokt.packet.buf

import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.readAvailable
import kotlin.experimental.and

/**
 * @author Jordan Abraham
 */
suspend fun ByteReadChannel.getPacketId(): Int = getAsBase64(2)
suspend fun ByteReadChannel.getPacketBodySize(): Int = getAsBase64(3)
suspend fun ByteReadChannel.getIntHabbo(): Int = getAsVl64(readByte().toInt()).toInt()
suspend fun ByteReadChannel.getLongHabbo(): Long = getAsVl64(readByte().toInt())
suspend fun ByteReadChannel.getStringHabbo(): String = String(ByteArray(getAsBase64(2)).also { readAvailable(it) })
suspend fun ByteReadChannel.getString(length: Int): String = String(ByteArray(length).also { readAvailable(it) })

private tailrec suspend fun ByteReadChannel.getAsBase64(
    size: Int,
    position: Int = 0,
    sum: Int = 0
): Int = if (position == size) sum else getAsBase64(size, position + 1, sum + ((readByte() - 64) shl 6 * (size - 1 - position)))

private tailrec suspend fun ByteReadChannel.getAsVl64(
    prefix: Int/* = readByte().toInt()*/, // The prefix byte at the first position.
    value: Long = (prefix and 3).toLong(), // Least significant bits of the first byte
    currentPosition: Int = 1 // Position of the next byte to decode
): Long {
    // The total number of bytes to read.
    val size = prefix shr 3 and 7
    return when {
        currentPosition < size -> {
            // Shift amount for the next byte's bits
            val remainingBits = 2 + (6 * (currentPosition - 1))
            val nextByte = (readByte() and 0x3F).toLong() shl remainingBits or value
            getAsVl64(prefix, nextByte, currentPosition + 1)
        }
        prefix and 4 == 4 -> -(value xor (((1 shl (size * 6)) - 1).toLong()))
        else -> value
    }
}