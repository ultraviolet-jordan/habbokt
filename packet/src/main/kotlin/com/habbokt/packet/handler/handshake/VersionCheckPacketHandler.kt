package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.api.client.DisconnectReason.Disconnect
import com.habbokt.packet.DisconnectReasonPacket
import com.habbokt.packet.VersionCheckPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckPacketHandler : PacketHandler<VersionCheckPacket>(Handler {
    // TODO Real validation against the local file instead of hard code.
    when {
        clientVersionId != 401 -> Disconnect
        clientUrl != "" -> Disconnect
        !clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt") -> Disconnect
        else -> null
    }?.let { disconnectReason ->
        it.writePacket(DisconnectReasonPacket(disconnectReason.id))
    }
})