package com.habbokt.api.packet

/**
 * @author Jordan Abraham
 */
open class PacketAssembler<out P : Packet>(
    val assembler: Assembler<@UnsafeVariance P>
)