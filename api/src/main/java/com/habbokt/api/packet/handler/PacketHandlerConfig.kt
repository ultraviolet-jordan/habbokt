package com.habbokt.api.packet.handler

import com.habbokt.api.packet.Packet
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
class PacketHandlerConfig {
    private val registered = HashMap<KClass<*>, PacketHandler<Packet>.() -> Unit>()

    val handlers: Map<KClass<*>, PacketHandler<Packet>.() -> Unit> get() = registered.toMap()

    fun register(clazz: KClass<*>, assembler: PacketHandler<Packet>.() -> Unit) {
        registered.keys.firstOrNull { it == clazz }?.let {
            throw IllegalArgumentException("There is already a registered packet handler for class type: ${clazz}.")
        }
        registered[clazz] = assembler
    }
}