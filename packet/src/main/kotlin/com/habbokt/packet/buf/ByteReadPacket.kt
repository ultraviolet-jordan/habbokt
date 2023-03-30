package com.habbokt.packet.buf

import io.ktor.utils.io.core.ByteReadPacket
import io.ktor.utils.io.core.readBytes

/**
 * @author Jordan Abraham
 */
fun ByteReadPacket.getPacketId(): Int = getAsBase64(2)
fun ByteReadPacket.getPacketBodySize(): Int = getAsBase64(3)
fun ByteReadPacket.getIntHabbo(): Int = getAsVl64()
fun ByteReadPacket.getStringHabbo(): String = String(readBytes(getAsBase64(2)))
fun ByteReadPacket.getString(length: Int): String = String(readBytes(length))

private tailrec fun ByteReadPacket.getAsBase64(
    size: Int,
    position: Int = 0,
    sum: Int = 0
): Int = if (position == size) sum else getAsBase64(
    size = size,
    position = position + 1,
    sum = sum + ((readByte() - 64) shl 6 * (size - 1 - position))
)

private tailrec fun ByteReadPacket.getAsVl64(
    prefix: Int = readByte().toInt(), // The prefix byte at the first position.
    value: Int = prefix and 3, // Least significant bits of the first byte
    position: Int = 1 // Position of the next byte to decode
): Int {
    // The total number of bytes to read.
    val size = prefix shr 3 and 7
    return if (position < size) {
        // Shift amount for the next byte's bits
        val shift = 2 + (6 * (position - 1))
        val nextByte = readByte().toInt() and 0x3F
        val nextValue = (nextByte shl shift) or value
        getAsVl64(prefix, nextValue, position + 1)
    } else {
        if (prefix and 4 == 4) -(value xor ((1 shl (size * 6)) - 1)) else value
    }
}