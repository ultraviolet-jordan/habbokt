package com.habbokt.game.packet.handler

import com.habbokt.api.client.DisconnectReason
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.VersionCheckPacket
import com.habbokt.api.packet.handler.handler

/**
 * @author Jordan Abraham
 */
val VersionCheckPacketHandler = handler<VersionCheckPacket> {
    if (packet.clientVersionId != 401) {
        // TODO Validate this against the real file instead of hard coded int.
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }

    if (packet.clientUrl != "") {
        // TODO Figure out how to populate this from the client.
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }

    if (!packet.clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt")) {
        // TODO Validate this against the real file instead of hard coded string.
        client.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@handler
    }
}