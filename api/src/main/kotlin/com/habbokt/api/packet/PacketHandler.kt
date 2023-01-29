package com.habbokt.api.packet

import com.habbokt.api.client.Client

/**
 * @author Jordan Abraham
 */
abstract class PacketHandler<out P : ProxyPacket>(
    val handler: Client.(@UnsafeVariance P) -> Unit
)