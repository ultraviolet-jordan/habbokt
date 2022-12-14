package com.habbokt.packet.dasm.handshake.sessionparameters

import com.google.inject.Singleton
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
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestProxyPacketHandler : ProxyPacketHandler<SessionParametersRequestPacket>(ProxyHandler {
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
    return@ProxyHandler SessionParametersRequestProxyPacket(sessionParameters)
})