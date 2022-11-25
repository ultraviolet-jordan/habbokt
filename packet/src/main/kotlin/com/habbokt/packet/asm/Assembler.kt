package com.habbokt.packet.asm

import com.habbokt.packet.Packet
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
data class Assembler<in P : Packet>(
    val id: Int,
    val block: P.(ByteBuffer) -> Unit
)