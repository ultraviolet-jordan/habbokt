package com.habbokt.game

import com.habbokt.packet.Packet

/**
 * @author Jordan Abraham
 */
interface Client {
    suspend fun awaitPacket(): Packet?
    fun handlePacket(packet: Packet)
    fun writePacket(packet: Packet)
}