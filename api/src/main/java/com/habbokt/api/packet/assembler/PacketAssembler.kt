package com.habbokt.api.packet.assembler

import com.habbokt.api.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class PacketAssembler(
    val id: Int,
    val packet: Packet.(ByteBuffer) -> Unit
)