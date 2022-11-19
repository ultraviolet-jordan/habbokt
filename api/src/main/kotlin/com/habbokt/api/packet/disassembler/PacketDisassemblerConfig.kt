package com.habbokt.api.packet.disassembler

/**
 * @author Jordan Abraham
 */
class PacketDisassemblerConfig {
    private val registered = HashMap<Int, PacketDisassembler>()

    val disassemblers: Map<Int, PacketDisassembler> get() = registered.toMap()

    fun register(id: Int, assembler: PacketDisassembler) {
        if (registered.containsKey(id)) {
            throw IllegalArgumentException("There is already a registered packet disassembler with id $id.")
        }
        registered[id] = assembler
    }
}