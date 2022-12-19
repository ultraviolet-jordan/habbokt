package com.habbokt.packet.buf

import io.ktor.utils.io.core.ByteReadPacket
import io.ktor.utils.io.core.readBytes
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
fun ByteReadPacket.getIntHabbo(): Int = readBytes(tryPeek() shr 3 and 7).vl64()
fun ByteReadPacket.getStringHabbo(): String = readBytes(readBytes(2).base64()).toString(StandardCharsets.UTF_8)
fun ByteReadPacket.getString(length: Int): String = readBytes(length).toString(StandardCharsets.UTF_8)