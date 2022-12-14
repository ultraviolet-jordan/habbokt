package com.habbokt.packet.dasm.handshake.versioncheck

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckProxyPacketHandler : ProxyPacketHandler<VersionCheckPacket>(ProxyHandler {
    // TODO Real validation against the local file instead of hard code.
    return@ProxyHandler when {
        clientVersionId != 401 -> null
        clientUrl != "" -> null
        !clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt") -> null
        else -> VersionCheckProxyPacket()
    }
//    when {
//        clientVersionId != 401 -> Disconnect
//        clientUrl != "" -> Disconnect
//        !clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt") -> Disconnect
//        else -> null
//    }?.let { disconnectReason ->
//        it.writePacket(DisconnectReasonPacket(disconnectReason.id))
//    }
})