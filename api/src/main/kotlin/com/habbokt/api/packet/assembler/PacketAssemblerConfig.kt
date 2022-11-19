package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.*
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
class PacketAssemblerConfig {
    private val registered = HashMap<KClass<*>, PacketAssemblerDeclaration<Packet>>()

    val declarations: Map<KClass<*>, PacketAssemblerDeclaration<Packet>> get() = registered.toMap()

    @PublishedApi
    internal fun <P : Packet> register(declaration: PacketAssemblerDeclaration<P>) {
        registered.values.firstOrNull { it.clazz == declaration.clazz }?.let {
            throw IllegalArgumentException("There is already a registered packet assembler with type: ${declaration.clazz}.")
        }
        @Suppress("UNCHECKED_CAST")
        registered[declaration.clazz] = declaration as PacketAssemblerDeclaration<Packet>
    }
}