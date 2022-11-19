package com.habbokt.api.packet.disassembler

/**
 * @author Jordan Abraham
 */
class PacketDisassemblerConfig {
    private val registered = HashMap<Int, PacketDisassemblerDeclaration>()

    val declarations: Map<Int, PacketDisassemblerDeclaration> get() = registered.toMap()

    @PublishedApi
    internal fun register(declaration: PacketDisassemblerDeclaration) {
        if (registered.containsKey(declaration.id)) {
            throw IllegalArgumentException("There is already a registered packet disassembler with id ${declaration.id}.")
        }
        registered[declaration.id] = declaration
    }
}