package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.api.packet.ProxyPacket
import com.habbokt.api.packet.ProxyPacketHandler
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
@Singleton
data class ServerConfiguration @Inject constructor(
    val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    val disassemblers: Map<Int, PacketDisassembler<Packet>>,
    val handlers: Map<KClass<*>, PacketHandler<ProxyPacket>>,
    val proxies: Map<KClass<*>, ProxyPacketHandler<Packet, ProxyPacket>>
)