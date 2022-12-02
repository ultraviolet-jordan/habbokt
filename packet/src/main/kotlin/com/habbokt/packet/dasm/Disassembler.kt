package com.habbokt.packet.dasm

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class Disassembler(
    val packet: (ByteBuffer) -> Packet
)