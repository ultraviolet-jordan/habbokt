package com.habbokt.api.packet

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
abstract class ProxyPacketHandler<out P : Packet, out T : ProxyPacket>(
    val handler: suspend Client.(@UnsafeVariance P) -> T?
)