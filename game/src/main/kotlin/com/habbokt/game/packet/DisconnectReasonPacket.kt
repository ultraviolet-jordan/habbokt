package com.habbokt.game.packet

/**
 * @author Jordan Abraham
 */
data class DisconnectReasonPacket(
    val reason: DisconnectReason
) : Packet

sealed class DisconnectReason(
    val id: Int
) {
    object Default : DisconnectReason(-1)
    object UrlLoggedOut : DisconnectReason(1)
    object UrlLoggedOutConcurrent : DisconnectReason(2)
    object UrlLogoutTimeout : DisconnectReason(3)
}