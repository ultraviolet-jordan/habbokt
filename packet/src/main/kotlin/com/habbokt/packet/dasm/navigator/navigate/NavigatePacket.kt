package com.habbokt.packet.dasm.navigator.navigate

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class NavigatePacket(
    val mask: Int,
    val id: Int,
    val depth: Int
) : Packet