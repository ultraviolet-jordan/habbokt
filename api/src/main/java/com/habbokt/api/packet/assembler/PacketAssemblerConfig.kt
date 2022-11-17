package com.habbokt.api.packet.assembler

import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
class PacketAssemblerConfig {
    private val registered = HashMap<KClass<*>, PacketAssembler<*>>()

    val assemblers: Map<KClass<*>, PacketAssembler<*>> get() = registered.toMap()

    fun register(clazz: KClass<*>, assembler: PacketAssembler<*>) {
        registered.values.firstOrNull { it.id == assembler.id }?.let {
            throw IllegalArgumentException("There is already a registered packet assembler with id ${assembler.id}.")
        }
        registered[clazz] = assembler
    }
}