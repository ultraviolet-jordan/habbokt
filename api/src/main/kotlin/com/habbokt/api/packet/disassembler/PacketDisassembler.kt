package com.habbokt.api.packet.disassembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class PacketDisassembler(
    val packet: (ByteBuffer) -> Packet
)