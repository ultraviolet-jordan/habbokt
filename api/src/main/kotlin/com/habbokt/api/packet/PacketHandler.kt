package com.habbokt.api.packet

/**
 * @author Jordan Abraham
 */
open class PacketHandler<out P : ProxyPacket>(
    val handler: Handler<@UnsafeVariance P>
)