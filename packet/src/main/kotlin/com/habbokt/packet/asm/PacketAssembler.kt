package com.habbokt.packet.asm

import com.habbokt.api.packet.Packet
import java.lang.reflect.ParameterizedType

/**
 * @author Jordan Abraham
 */
open class PacketAssembler<out P : Packet>(
    val assembler: Assembler<@UnsafeVariance P>
) {
    /**
     * Weird solution of checking if a packet is of type of this assembler since assemblers are basically keyed by class type.
     */
//    fun typeOf(packet: @UnsafeVariance P): Boolean = (this::class.java.genericSuperclass as ParameterizedType)
//        .actualTypeArguments
//        .firstOrNull()
//        ?.typeName == packet::class.java.typeName
}