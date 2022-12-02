package com.habbokt.packet.handler

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
open class PacketHandler<out P : Packet>(
    val handler: Handler<@UnsafeVariance P>
)