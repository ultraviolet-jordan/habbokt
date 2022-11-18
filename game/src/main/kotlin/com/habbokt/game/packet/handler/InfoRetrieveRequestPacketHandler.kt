package com.habbokt.game.packet.handler

import com.habbokt.api.client.handshake.SessionParameter
import com.habbokt.api.client.handshake.SessionParameterId.AllowDirectMail
import com.habbokt.api.client.handshake.SessionParameterId.Coppa
import com.habbokt.api.client.handshake.SessionParameterId.DateFormatter
import com.habbokt.api.client.handshake.SessionParameterId.ParentEmailRequest
import com.habbokt.api.client.handshake.SessionParameterId.ParentEmailRequestRegistration
import com.habbokt.api.client.handshake.SessionParameterId.PartnerIntegration
import com.habbokt.api.client.handshake.SessionParameterId.ProfileEditing
import com.habbokt.api.client.handshake.SessionParameterId.TrackingHeader
import com.habbokt.api.client.handshake.SessionParameterId.TutorialEnabled
import com.habbokt.api.client.handshake.SessionParameterId.Voucher
import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.InfoRetrieveRequestPacket
import com.habbokt.api.packet.InfoRetrieveResponsePacket
import com.habbokt.api.packet.handler.PacketHandlerConfig
import com.habbokt.api.packet.handler.packet

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