package com.habbokt.api.packet

import io.ktor.utils.io.core.ByteReadPacket

/**
 * @author Jordan Abraham
 */
abstract class PacketDisassembler<out P : Packet>(
    val body: ByteReadPacket.() -> @UnsafeVariance P
)