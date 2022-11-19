package com.habbokt.api.packet.handler

import com.habbokt.api.packet.*
import kotlin.reflect.*

/**
 * @author Jordan Abraham
 */
data class PacketHandlerDeclaration<in P : Packet>(
    val clazz: KClass<*>,
    val handler: suspend PacketHandler<P>.() -> Unit
)