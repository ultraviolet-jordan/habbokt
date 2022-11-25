package com.habbokt.game.common

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

/**
 * @author Jordan Abraham
 */
private fun ByteBuffer.moveToByteArray(amount: Int): ByteArray = ByteArray(amount) { get() }

fun ByteBuffer.getIntHabbo(): Int = moveToByteArray(this[position()].toInt() shr 3 and 7).vl64()
fun ByteBuffer.getStringHabbo(): String = String(moveToByteArray(ByteArray(2) { get() }.base64()), StandardCharsets.UTF_8)

fun ByteBuffer.putIntHabbo(value: Int): ByteBuffer = put(value.vl64())
fun ByteBuffer.putStringHabbo(value: String): ByteBuffer = put(value.toByteArray(StandardCharsets.UTF_8)).put(2)