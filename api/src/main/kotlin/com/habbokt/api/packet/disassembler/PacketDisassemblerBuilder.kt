package com.habbokt.api.packet.disassembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
inline fun <reified P : Packet> disassembler(
    id: Int,
    noinline block: (ByteBuffer) -> P
): PacketDisassemblerDeclaration = PacketDisassemblerDeclaration(id, PacketDisassembler(block))

fun PacketDisassemblerConfig.disassemblers(vararg disassemblers: PacketDisassemblerDeclaration) {
    disassemblers.forEach(::register)
}