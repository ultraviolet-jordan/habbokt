package com.habbokt.game.packet.handler

import com.habbokt.api.etc.DisconnectReason
import com.habbokt.api.packet.handler.PacketHandlerListener
import com.habbokt.game.packet.DisconnectReasonPacket
import com.habbokt.game.packet.VersionCheckPacket

/**
 * @author Jordan Abraham
 */
fun PacketHandlerListener.versionCheckPacket() {
    handlePacket<VersionCheckPacket> {
        if (packet.clientVersionId != 401) {
            // TODO Validate this against the real file instead of hard coded int.
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Default))
            return@handlePacket
        }

        if (packet.clientUrl != "") {
            // TODO Figure out how to populate this from the client.
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Default))
            return@handlePacket
        }

        if (!packet.clientVarsUrl.startsWith("http://localhost/dcr/v31/gamedata/external_variables.txt")) {
            // TODO Validate this against the real file instead of hard coded string.
            client.writePacket(DisconnectReasonPacket(DisconnectReason.Default))
            return@handlePacket
        }
    }
}