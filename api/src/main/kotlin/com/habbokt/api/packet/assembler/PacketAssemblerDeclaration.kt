package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.Packet
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
data class PacketAssemblerDeclaration<in P : Packet>(
    val clazz: KClass<*>,
    val assembler: PacketAssembler<P>
)