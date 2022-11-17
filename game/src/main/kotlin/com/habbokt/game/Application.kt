package com.habbokt.game

import com.habbokt.api.buffer.base64
import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.game.packet.PacketFactory
import com.habbokt.api.packet.handler.PacketHandler
import com.habbokt.api.packet.handler.PacketHandlerListener
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.Application
import io.ktor.server.application.log
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.ByteReadPacket
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.util.concurrent.Executors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
private val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
private val selector = ActorSelectorManager(dispatcher)

fun Application.module() {
    PacketFactory.init()

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

            launch(Dispatchers.IO) {
                val client = GameClient(
                    readChannel = socket.openReadChannel(),
                    writeChannel = socket.openWriteChannel()
                )

                try {
                    while (true) {
                        val readPacket = client.awaitPacket() ?: continue
                        val handler = PacketHandler(client, readPacket)
                        PacketHandlerListener[handler.packet::class]?.invoke(handler)
                    }
                } catch (exception: Exception) {
                    log.error("Exception caught by connected client. Disconnecting...", exception)
                    socket.close()
                }
            }

//            launch(Dispatchers.IO) {
//                while (true) {
//                    val numBytes = readChannel.availableForRead
//
//
//                    if (numBytes < 5) {
//                        continue
//                    }
//                    log.info("ReadChannel NumBytes=$numBytes")
//
//                    val size = ByteArray(3) { readChannel.readByte() }.base64()
//                    if (readChannel.availableForRead < size) {
//                        continue
//                    }
//
//                    if (size >= 0) {
//                        val buffer = ByteBuffer.wrap(readChannel.readPacket(size).readBytes())
//                        val header = String(ByteArray(2) { buffer.get() })
//                        val id = header.toByteArray().base64()
//
//                        log.info("Incoming: Header=$header, Id=$id, Size=$size")
//
//                        when {
//                            // Incoming InitDiffieHandshakeMessageComposer
//                            id == 206 && header == "CN" -> InitDiffieHandshakeEvent(writeChannel)
//                            // Incoming CompleteDiffieHandshakeMessageComposer
////                            id == 2002 && header == "_R" -> CompleteDiffieHandshakeEvent(buffer, writeChannel)
////                            // Incoming InfoRetrieveMessageComposer
////                            id == 1817 && header == "\\Y" -> InfoRetrieveMessageEvent(writeChannel)
////                            // Incoming SSOTicketMessageComposer
////                            id == 204 && header == "CL" -> SSOTicketMessageEvent(buffer, writeChannel)
////                            // Incoming VersionCheckMessageComposer
////                            id == 1170 && header == "RR" -> VersionCheckMessageComposer(buffer)
//                        }
//                    }
//                }
//            }
        }
    }
}

suspend fun Application.InitDiffieHandshakeEvent(writeChannel: ByteWriteChannel) {
    log.info("InitDiffieHandshakeEvent")
    writeChannel.writeFully(writePacket(277, 2) {
        val random = uuid(32)
        log.info("Set Key = $random")
        ByteBuffer.allocate(random.length + 2).apply {
            putStringHabbo(random)
            putIntHabbo(0)
        }
    })

//    writeChannel.apply {
//        // Start packet with ID 277
//        writePacket(ByteReadPacket(base64Encode(277, 2)))
//        val random = uuid(32)
//        log.info("Set Key = $random")
//        // writeString
//        writePacket(ByteReadPacket(random.toByteArray(StandardCharsets.UTF_8)))
//        writeByte(2)
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0)))
//        // End packet
//        writeByte(1)
//    }.flush()
}

suspend fun Application.CompleteDiffieHandshakeEvent(read: ByteBuffer, writeChannel: ByteWriteChannel) {
    log.info("CompleteDiffieHandshakeEvent")
    writeChannel.apply {
        val key = read.getStringHabbo()
        log.info("Key = $key")
        // Start packet with ID 1
        writePacket(ByteReadPacket(1.base64(2)))
        val random = uuid(24)
        log.info("Set Key = $random")
        writePacket(ByteReadPacket(random.toByteArray(StandardCharsets.UTF_8)))
        // End packet
        writeByte(1)
    }.flush()
}

//suspend fun Application.InfoRetrieveMessageEvent(writeChannel: ByteWriteChannel) {
//    log.info("InfoRetrieveMessageEvent")
//    writeChannel.apply {
//        // Start packet with ID 257
//        writePacket(ByteReadPacket(base64Encode(257, 2)))
//
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(9))) // Size
//
//        // Vouchers
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(1))) // Id
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(1))) // True
//
//        // Parent email address
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(2))) // Id
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0))) // False
//
//        // Parent email address registered
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(3))) // Id
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0))) // False
//
//        // Allow direct mail
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(4))) // Id
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0))) // False
//
//        // Date format
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(5)))
//        // writeString
//        writePacket(ByteReadPacket("yyyy-MM-dd".toByteArray(StandardCharsets.UTF_8)))
//        writeByte(2)
//
//        // Partner integration
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(6)))
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0))) // False
//
//        // Allow profile editing
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(7)))
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(1))) // True
//
//        // Tracking header
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(8)))
//        // writeString
//        writePacket(ByteReadPacket("".toByteArray(StandardCharsets.UTF_8)))
//        writeByte(2)
//
//        // Tutorial enabled
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(9)))
//        // writeInt
//        writePacket(ByteReadPacket(vl64Encode(0))) // False
//
//        // End packet
//        writeByte(1)
//    }.flush()
//}

//suspend fun Application.SSOTicketMessageEvent(read: ByteBuffer, writeChannel: ByteWriteChannel) {
//    writeChannel.apply {
//        val key = read.readStringHabbo()
//        log.info("SSO = $key")
//
//        // UniqueMachineIDEvent
//        UniqueMachineIDEvent(writeChannel)
//        // UserRightsMessageEvent
//        UserRightsMessageEvent(writeChannel)
//        // AuthenticationOKMessageEvent
//        AuthenticationOKMessageEvent(writeChannel)
//    }.flush()
//}

//suspend fun Application.UniqueMachineIDEvent(writeChannel: ByteWriteChannel) {
//    log.info("UniqueMachineIDEvent")
//    writeChannel.apply {
//        // Start packet with ID 439
//        writePacket(ByteReadPacket(base64Encode(439, 2)))
//        val uniqueMachineId = "#${UUID.randomUUID().toString().uppercase().replace("-", "")}"
//        // writeString
//        writePacket(ByteReadPacket(uniqueMachineId.toByteArray(StandardCharsets.UTF_8)))
//        writeByte(2)
//        // End packet
//        writeByte(1)
//    }.flush()
//}

//suspend fun Application.UserRightsMessageEvent(writeChannel: ByteWriteChannel) {
//    log.info("UserRightsMessageEvent")
//    writeChannel.apply {
//        // Start packet with ID 2
//        writePacket(ByteReadPacket(base64Encode(2, 2)))
//        // End packet
//        writeByte(1)
//    }.flush()
//}

suspend fun Application.AuthenticationOKMessageEvent(writeChannel: ByteWriteChannel) {
    log.info("AuthenticationOKMessageEvent")
    writeChannel.writeAvailable(writePacket(3, 2) {null})
//    writeChannel.apply {
//        // Start packet with ID 3
//        writePacket(ByteReadPacket(base64Encode(3, 2)))
//        // End packet
//        writeByte(1)
//    }.flush()
}

//fun Application.VersionCheckMessageComposer(buffer: ByteBuffer) {
//    val versionId = buffer.readIntHabbo()
//    log.info("Client VersionId = $versionId")
//    val clientUrl = buffer.readStringHabbo()
//    log.info("Client URL = $clientUrl")
//    val varsUrl = buffer.readStringHabbo()
//    log.info("Vars URL = $varsUrl")
//    buffer.putin
//}

//fun ByteBuffer.readIntHabbo(): Int = vl64Decode(moveToByteArray(this[position()].toInt() shr 3 and 7))
//
//fun ByteBuffer.moveToByteArray(amount: Int): ByteArray = ByteArray(amount) { get() }

//fun ByteReadPacket.readIntHabbo(): Int {
//    val copy = copy().readBytes()
//    val size = copy[0].toInt() shr 3 and 7
//    val result = vl64Decode(copy)
//    discard(size)
//    return result
//    return vl64Decode(readBytes(tryPeek() shr 3 and 7))
//}

//fun ByteBuffer.readStringHabbo(): String = String(moveToByteArray(base64Decode(ByteArray(2) { get() })), StandardCharsets.UTF_8)

//fun ByteReadPacket.readStringHabbo(): String {
//    return String(readBytes(base64Decode(ByteArray(2) { readByte() })), StandardCharsets.UTF_8)
//}

fun writePacket(id: Int, size: Int, block: () -> ByteBuffer?): ByteBuffer {
    val buffer = block.invoke()
    return ByteBuffer.allocate(2 + (buffer?.position() ?: 0)).apply {
        put(id.base64(size))
        put(buffer)
        put(1)
    }.flip()
}

//fun ByteBuffer.writeInt(value: Int): ByteBuffer = put(vl64Encode(value))

//fun ByteBuffer.writeString(value: String): ByteBuffer = put(value.toByteArray(StandardCharsets.UTF_8)).put(2)

//fun base64Encode(value: Int, size: Int): ByteArray = ByteArray(size) { (((value shr 6 * (size - 1 - it)) and 0x3f) + 0x40).toByte() }

//fun base64Encode(id: Int, size: Int): ByteArray {
//    val encodedArray = ByteArray(size)
//    for (index in 1..size) {
//        val k = (size - index) * 6
//        encodedArray[index - 1] = (0x40 + (id shr k and 0x3f)).toByte()
//    }
//    return encodedArray
//}

//fun base64Decode(value: ByteArray): Int = value.foldIndexed(0) { index, sum, x -> sum + ((x - 0x40) shl 6 * (value.size - 1 - index)) }

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

//fun vl64Encode(value: Int): ByteArray {
//    val vlEncoded = ByteArray(6)
//
//    var size = 1
//    var absoluteValue = abs(value)
//
//    vlEncoded[0] = (64 + (absoluteValue and 3)).toByte()
//
//    absoluteValue = absoluteValue shr 2
//
//    while (absoluteValue != 0) {
//        size++
//        vlEncoded[size - 1] = (64 + (absoluteValue and 0x3f)).toByte()
//        absoluteValue = absoluteValue shr 6
//    }
//
//    vlEncoded[0] = (vlEncoded[0].toInt() or (size shl 3) or if (value >= 0) 0 else 4).toByte()
//
//    return ByteArray(size).apply {
//        System.arraycopy(vlEncoded, 0, this, 0, size)
//    }

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
//}

//fun vl64Decode(value: ByteArray): Int {
//    val first = value[0].toInt()
//    var result = first and 3
//    repeat(first shr 3 and 7) {
//        result = result or (value[it + 2].toInt() and 0x3) shl 2 + (it * 6)
//    }
//    return if (first and 4 == 4) result else -result
//}

//fun vl64Decode(value: ByteArray): Int {
//    val negative = value[0].toInt() and 4 == 4
//    val size = value[0].toInt() shr 3 and 7
//
//    var result = value[0].toInt() and 3
//
//    var shiftAmount = 2
//
//    for (b in 1 until size) {
//        result = result or (value[b].toInt() and 0x3f shl shiftAmount)
//        shiftAmount = 2 + 6 * b
//    }
//
//    return if (negative) -result else result
//}

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