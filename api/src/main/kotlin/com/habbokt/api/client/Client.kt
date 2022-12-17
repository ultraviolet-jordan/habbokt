package com.habbokt.api.client

import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet
import io.ktor.network.sockets.SocketAddress

/**
 * @author Jordan Abraham
 */
interface Client {
    suspend fun accept()
    suspend fun awaitPacket(): Packet?
    fun processReadPool()
    fun writePacket(packet: Packet)
    fun processWritePool()
    fun authenticate(userId: Int)
    fun player(): Player?
    fun close()
    fun connected(): Boolean
    fun socketAddress(): SocketAddress
}