package com.habbokt.api.client

import com.habbokt.api.packet.Packet
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
interface Client {
    fun readChannel(): ByteReadChannel
    fun writeChannel(): ByteWriteChannel
    fun bufferPool(): ByteBuffer
    suspend fun awaitPacket(): Packet?
    fun handlePacket(packet: Packet)
    fun writePacket(packet: Packet)
}