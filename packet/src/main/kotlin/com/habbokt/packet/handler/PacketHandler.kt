package com.habbokt.packet.handler

import com.habbokt.api.packet.Packet
import java.lang.reflect.ParameterizedType

/**
 * @author Jordan Abraham
 */
open class PacketHandler<in P : Packet>(
    val handler: Handler<P>
) {
    /**
     * Weird solution of checking if a packet is of type of this assembler since assemblers are basically keyed by class type.
     */
    fun typeOf(packet: P): Boolean = (this::class.java.genericSuperclass as ParameterizedType)
        .actualTypeArguments
        .firstOrNull()
        ?.typeName == packet::class.java.typeName
}