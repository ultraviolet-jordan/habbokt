package com.habbokt.game.packet.handler

import com.habbokt.api.client.handshake.SessionParameter
import com.habbokt.api.client.handshake.SessionParameterId.*
import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet
import com.habbokt.game.packet.InfoRetrieveRequestPacket
import com.habbokt.game.packet.InfoRetrieveResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketHandlerConfig.installInfoRetrieveRequestPacket() {
    packet<InfoRetrieveRequestPacket> {
        val sessionParameters = SessionParameters(
            SessionParameter(Coppa, false),
            SessionParameter(Voucher, true),
            SessionParameter(ParentEmailRequest, false),
            SessionParameter(ParentEmailRequestRegistration, false),
            SessionParameter(AllowDirectMail, false),
            SessionParameter(DateFormatter, "yyyy-MM-dd"),
            SessionParameter(PartnerIntegration, false),
            SessionParameter(ProfileEditing, true),
            SessionParameter(TrackingHeader, ""),
            SessionParameter(TutorialEnabled, false)
        )

        client.writePacket(InfoRetrieveResponsePacket(sessionParameters))
    }
}