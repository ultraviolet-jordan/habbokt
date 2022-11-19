package com.habbokt.api.packet.handler

import com.habbokt.api.packet.*
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
class PacketHandlerConfig {
    private val registered = HashMap<KClass<*>, PacketHandlerDeclaration<Packet>>()

    val declarations: Map<KClass<*>, PacketHandlerDeclaration<Packet>> get() = registered.toMap()

    @PublishedApi
    internal fun register(declaration: PacketHandlerDeclaration<*>) {
        registered.values.firstOrNull { it.clazz == declaration.clazz }?.let {
            throw IllegalArgumentException("There is already a registered packet handler for class type: ${declaration.clazz}.")
        }
        @Suppress("UNCHECKED_CAST")
        registered[declaration.clazz] = declaration as PacketHandlerDeclaration<Packet>
    }
}