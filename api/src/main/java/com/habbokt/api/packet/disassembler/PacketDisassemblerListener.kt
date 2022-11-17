package com.habbokt.api.packet.disassembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
object PacketDisassemblerListener : MutableMap<Int, PacketDisassembler> by mutableMapOf() {
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : Packet> disassemblePacket(opcode: Int, noinline packet: (ByteBuffer) -> T) {
        this[opcode] = PacketDisassembler(packet)
    }
}