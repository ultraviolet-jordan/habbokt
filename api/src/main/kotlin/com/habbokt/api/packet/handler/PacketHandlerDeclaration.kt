package com.habbokt.api.packet.handler

import com.habbokt.api.packet.Packet
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
data class PacketHandlerDeclaration<in P : Packet>(
    val clazz: KClass<*>,
    val handler: suspend PacketHandler<P>.() -> Unit
)