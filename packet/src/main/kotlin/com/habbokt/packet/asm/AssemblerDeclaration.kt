package com.habbokt.packet.asm

import com.habbokt.packet.Packet
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
data class PacketAssemblerDeclaration<in P : Packet>(
    val kClass: KClass<*>,
    val assembler: Assembler<P>
)