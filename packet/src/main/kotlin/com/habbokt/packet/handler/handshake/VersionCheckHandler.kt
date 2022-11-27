package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.api.client.DisconnectReason
import com.habbokt.packet.DisconnectReasonPacket
import com.habbokt.packet.VersionCheckPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckHandler : HandlerListener<VersionCheckPacket>(Handler {
    if (clientVersionId != 401) {
        // TODO Validate this against the real file instead of hard coded int.
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@Handler
    }

    if (clientUrl != "") {
        // TODO Figure out how to populate this from the client.
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@Handler
    }

    if (!clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt")) {
        // TODO Validate this against the real file instead of hard coded string.
        it.writePacket(DisconnectReasonPacket(DisconnectReason.Disconnect))
        return@Handler
    }
})