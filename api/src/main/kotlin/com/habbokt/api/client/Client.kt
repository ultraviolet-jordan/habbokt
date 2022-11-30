package com.habbokt.api.client

import com.habbokt.api.entity.player.Player
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
interface Client {
    suspend fun awaitPacket(): Packet?
    fun handlePacket(packet: Packet)
    fun writePacket(packet: Packet)
    fun authenticate(userId: Int)
    fun player(): Player?
    fun close()
}