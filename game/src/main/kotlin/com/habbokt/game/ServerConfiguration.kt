package com.habbokt.game

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.Packet
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.dasm.PacketDisassembler
import com.habbokt.packet.handler.PacketHandler
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
@Singleton
data class ServerConfiguration @Inject constructor(
    val assemblers: Map<KClass<*>, PacketAssembler<Packet>>,
    val disassemblers: Map<Int, PacketDisassembler>,
    val handlers: Map<KClass<*>, PacketHandler<Packet>>
)