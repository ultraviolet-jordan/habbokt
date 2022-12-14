package com.habbokt.api.packet

import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class Disassembler(
    val packet: (ByteBuffer) -> Packet
)