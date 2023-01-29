package com.habbokt.packet.dasm.handshake.versioncheck

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckProxyPacketHandler : ProxyPacketHandler<VersionCheckPacket, VersionCheckProxyPacket>(
    handler = {
        // TODO Real validation against the local file instead of hard code.
        when {
            it.clientVersionId != 401 -> null
            it.clientUrl != "" -> null
            !it.clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt") -> null
            else -> VersionCheckProxyPacket()
        }
    }
)