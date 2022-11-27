package com.habbokt.packet.asm

import com.habbokt.packet.Packet
import java.lang.reflect.ParameterizedType

/**
 * @author Jordan Abraham
 */
abstract class AssemblerListener<P : Packet>(
    val assembler: Assembler<P>
) {
    /**
     * Weird solution of checking if a packet is of type of this assembler since assemblers are basically keyed by class type.
     */
    fun typeOf(packet: Packet) = (this::class.java.genericSuperclass as ParameterizedType)
        .actualTypeArguments
        .firstOrNull()
        ?.typeName == packet::class.java.typeName
}