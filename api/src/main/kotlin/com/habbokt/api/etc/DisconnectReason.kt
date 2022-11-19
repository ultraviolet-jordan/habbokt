package com.habbokt.api.etc

/**
 * @author Jordan Abraham
 */
sealed class DisconnectReason(
    val id: Int
) {
    object Disconnect : DisconnectReason(-1)
    object UrlLoggedOut : DisconnectReason(1)
    object UrlLoggedOutConcurrent : DisconnectReason(2)
    object UrlLogoutTimeout : DisconnectReason(3)
}