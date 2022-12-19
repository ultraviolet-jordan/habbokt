package com.habbokt.packet.buf

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
fun ByteBuffer.putIntHabbo(value: Int): ByteBuffer = put(value.vl64())
fun ByteBuffer.putStringHabbo(value: String): ByteBuffer = put(value.toByteArray(StandardCharsets.UTF_8)).put(2)