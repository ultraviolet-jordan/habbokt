package com.habbokt.packet.asm

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
open class PacketAssembler<out P : Packet>(
    val assembler: Assembler<@UnsafeVariance P>
)