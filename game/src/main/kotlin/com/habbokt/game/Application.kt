package com.habbokt.game

import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.ByteReadPacket
import io.ktor.utils.io.core.readBytes
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.util.concurrent.Executors
import kotlin.math.abs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
fun Application.module() {
    val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
    val selector = ActorSelectorManager(dispatcher)

    val hostname = "127.0.0.1"
    val port = 43594

    runBlocking {
        val server = aSocket(selector).tcp().bind(hostname, port) {
            backlogSize = 1000
            reuseAddress = true
        }

        log.info("Responding at http://$hostname:$port")

        while (true) {
            val socket = server.accept()

            // TODO
            val readChannel = socket.openReadChannel()
            val writeChannel = socket.openWriteChannel()

            launch(Dispatchers.IO) {
                while (true) {
                    val numBytes = readChannel.availableForRead


                    if (numBytes < 5) {
                        continue
                    }
                    log.info("ReadChannel NumBytes=$numBytes")

                    val size = base64Decode(ByteArray(3) { readChannel.readByte() })
                    if (readChannel.availableForRead < size) {
                        continue
                    }

                    if (size >= 0) {
                        val buffer = readChannel.readPacket(size)
                        val header = String(ByteArray(2) { buffer.readByte() })
                        val id = base64Decode(header.toByteArray())

                        log.info("Incoming: Header=$header, Id=$id, Size=$size")

                        when {
                            // Incoming InitDiffieHandshakeMessageComposer
                            id == 206 && header == "CN" -> InitDiffieHandshakeEvent(writeChannel)
                            // Incoming CompleteDiffieHandshakeMessageComposer
                            id == 2002 && header == "_R" -> CompleteDiffieHandshakeEvent(buffer, writeChannel)
                        }
                    }
                }
            }
        }
    }
}

suspend fun Application.InitDiffieHandshakeEvent(writeChannel: ByteWriteChannel) {
    log.info("InitDiffieHandshakeEvent")
    writeChannel.apply {
        // Start packet with ID 277
        writePacket(ByteReadPacket(base64Encode(277, 2)))
        val random = uuid(32)
        log.info("Set Key = $random")
        // writeString
        writePacket(ByteReadPacket(random.toByteArray(StandardCharsets.UTF_8)))
        writeByte(2)
        // writeInt
        writePacket(ByteReadPacket(vl64Encode(0)))
        // End  packet
        writeByte(1)
    }.flush()
}

suspend fun Application.CompleteDiffieHandshakeEvent(read: ByteReadPacket, writeChannel: ByteWriteChannel) {
    log.info("CompleteDiffieHandshakeEvent")
    writeChannel.apply {
        val key = String(read.readBytes(base64Decode(ByteArray(2) { read.readByte() })), StandardCharsets.UTF_8)
        log.info("Key = $key")
        // Start packet with ID 277
        writePacket(ByteReadPacket(base64Encode(1, 2)))
        val random = uuid(24)
        log.info("Set Key = $random")
        writePacket(ByteReadPacket(random.toByteArray(StandardCharsets.UTF_8)))
        // End  packet
        writeByte(1)
    }.flush()
}

fun base64Encode(value: Int, size: Int): ByteArray = ByteArray(size) { (((value shr 6 * (size - 1 - it)) and 0x3f) + 0x40).toByte() }

//fun base64Encode(id: Int, size: Int): ByteArray {
//    val encodedArray = ByteArray(size)
//    for (index in 1..size) {
//        val k = (size - index) * 6
//        encodedArray[index - 1] = (0x40 + (id shr k and 0x3f)).toByte()
//    }
//    return encodedArray
//}

fun base64Decode(value: ByteArray): Int = value.fold(0) { sum, x -> sum + ((x - 0x40) shl 6 * (value.size - 1 - value.indexOf(x))) }

//fun base64Decode(encodedArray: ByteArray): Int {
//    var value = 0
//    for ((j, k) in encodedArray.indices.reversed().withIndex()) {
//        var x = encodedArray[k] - 0x40
//        if (j > 0) x *= 64.0.pow(j.toDouble()).toInt()
//        value += x
//    }
//    return value
//}

fun uuid(length: Int) = buildString {
    val numbers = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
    repeat(length) {
        append(numbers[SecureRandom().nextInt(numbers.size)].toString())
    }
}

fun vl64Encode(value: Int): ByteArray {
    val vlEncoded = ByteArray(6)

    var size = 1
    var absoluteValue = abs(value)

    // Negative or not.
    vlEncoded[0] = (0x40 + (absoluteValue and 3)).also { if (value < 0) it or 4 else it or 0 }.toByte()

    absoluteValue = absoluteValue shr 2

    while (absoluteValue != 0) {
        size += 1
        vlEncoded[size] = ((0x40 + (absoluteValue and 0x3f)).toByte())
        absoluteValue = absoluteValue shr 6
    }

    vlEncoded[0] = (vlEncoded[0].toInt() or size shl 3).toByte()

    return ByteArray(size).apply {
        System.arraycopy(vlEncoded, 0, this, 0, size)
    }

//    val array = ByteArray(6)
//    var position = 0
//    var numBytes = 1
//    val startPosition = 0
//    val negativeMask = if (x >= 0) 0 else 4
//    var i = abs(x)
//    array[position++] = (64 + (i and 3)).toByte()
//    i = i shr 2
//    while (i != 0) {
//        numBytes++
//        array[position++] = (64 + (i and 0x3f)).toByte()
//        i = i shr 6
//    }
//    array[startPosition] = (array[startPosition].toInt() or (numBytes shl 3) or negativeMask).toByte()
//    val encoded = ByteArray(numBytes)
//    System.arraycopy(array, 0, encoded, 0, numBytes)
//    return encoded
}

fun vl64Decode(value: ByteArray): Int {
    val first = value[0].toInt()
    var result = first and 3
    repeat(first shr 3 and 7) {
        result = result or (value[it + 2].toInt() and 0x3) shl 2 + (it * 6)
    }
    return if (first and 4 == 4) result else -result
}

//fun vl64Decode(value: ByteArray): Int {
//    val isNegative = value[0].toInt() and 4 == 4
//    val size = value[0].toInt() shr 3 and 7
//
//    var result = value[0].toInt() and 3
//    var shiftAmount = 2
//
//    for (b in 1..size) {
//        result = result or (value[b + 1].toInt() and 0x3) shl shiftAmount
//        shiftAmount += 6
//    }
//
//    return if (isNegative) result else -result
//}