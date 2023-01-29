package com.habbokt.api.packet

import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
abstract class PacketAssembler<out P : Packet>(
    val id: Int,
    val body: ByteBuffer.(@UnsafeVariance P) -> Unit
)