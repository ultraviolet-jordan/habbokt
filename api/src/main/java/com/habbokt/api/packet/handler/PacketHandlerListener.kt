package com.habbokt.api.packet.handler

import com.habbokt.api.packet.Packet
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
object PacketHandlerListener : MutableMap<KClass<*>, PacketHandler<Packet>.() -> Unit> by mutableMapOf() {
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : Packet> handlePacket(noinline listener: PacketHandler<T>.() -> Unit) {
        this[T::class] = listener as PacketHandler<Packet>.() -> Unit
    }
}