package com.habbokt.api.packet

import io.ktor.utils.io.core.ByteReadPacket

/**
 * @author Jordan Abraham
 */
data class Disassembler(
    val packet: (ByteReadPacket) -> Packet
)