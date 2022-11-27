package com.habbokt.packet.buf

/**
 * @author Jordan Abraham
 */
fun ByteArray.base64(): Int = foldIndexed(0) { index, sum, x -> sum + ((x - 0x40) shl 6 * (size - 1 - index)) }
fun Int.base64(size: Int): ByteArray = ByteArray(size) { (((this shr 6 * (size - 1 - it)) and 0x3f) + 0x40).toByte() }