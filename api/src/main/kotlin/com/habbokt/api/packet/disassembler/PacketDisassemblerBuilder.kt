package com.habbokt.api.packet.disassembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
inline fun <reified P : Packet> PacketDisassemblerConfig.packet(
    id: Int,
    noinline block: (ByteBuffer) -> P
) {
    val disassembler = PacketDisassembler(block)
    packet(id, disassembler)
}

@PublishedApi
internal fun PacketDisassemblerConfig.packet(id: Int, assembler: PacketDisassembler) {
    register(id, assembler)
}