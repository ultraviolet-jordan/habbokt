package com.habbokt.api.packet

/**
 * @author Jordan Abraham
 */
open class ProxyPacketHandler<out P : Packet>(
    val handler: ProxyHandler<@UnsafeVariance P>
)