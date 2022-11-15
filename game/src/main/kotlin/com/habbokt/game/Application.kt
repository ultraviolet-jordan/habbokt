package com.habbokt.game

import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.server.application.Application
import io.ktor.server.application.log
import java.util.concurrent.Executors
import kotlin.math.pow
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
                readChannel.awaitContent()
                val numBytes = readChannel.availableForRead

                log.info("ReadChannel NumBytes=$numBytes")

                if (numBytes < 5) {
                    readChannel.awaitContent()
                }

                val size = decode(ByteArray(3) { readChannel.readByte() })
                if (readChannel.availableForRead < size) {
                    readChannel.awaitContent()
                }

                println(String(encode(206, 2)))

                if (size >= 0) {
                    val buffer = readChannel.readPacket(size)
                    val header = String(ByteArray(2) { buffer.readByte() })
                    val id = decode(header.toByteArray())

                    log.info("Incoming: Header=$header, Id=$id")

                    if (id == 206 && header == "CN") { // InitDiffieHandshakeMessageComposer
                        log.info("InitDiffieHandshakeMessageComposer")
                        println(String(encode(206, 2)) == "CN") // Encoding works.
                        println(readChannel.availableForRead == 0) // All read.
                    }
                }
            }
        }
    }
}

fun encode(id: Int, size: Int): ByteArray {
    val encodedArray = ByteArray(size)
    for (index in 1..size) {
        val k = (size - index) * 6
        encodedArray[index - 1] = (0x40 + (id shr k and 0x3f)).toByte()
    }
    return encodedArray
}

fun decode(encodedArray: ByteArray): Int {
    var value = 0
    for ((j, k) in encodedArray.indices.reversed().withIndex()) {
        var x = encodedArray[k] - 0x40
        if (j > 0) x *= 64.0.pow(j.toDouble()).toInt()
        value += x
    }
    return value
}