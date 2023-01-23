package com.habbokt.packet.buf

/**
 * @author Jordan Abraham
 */
fun ByteArray.base64(): Int = foldIndexed(0) { index, sum, x -> sum + ((x - 64) shl 6 * (size - 1 - index)) }
fun Int.base64(): ByteArray = ByteArray(2) { (((this shr 6 * (1 - it)) and 0x3f) + 64).toByte() }