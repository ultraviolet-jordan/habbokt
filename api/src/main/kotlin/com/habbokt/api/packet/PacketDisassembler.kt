package com.habbokt.api.packet

import io.ktor.utils.io.ByteReadChannel

/**
 * @author Jordan Abraham
 */
abstract class PacketDisassembler<out P : Packet>(
    val body: suspend ByteReadChannel.(Int) -> @UnsafeVariance P
)