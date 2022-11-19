package com.habbokt.api.client.handshake

/**
 * @author Jordan Abraham
 */
class SessionParameters(
    vararg parameters: SessionParameter
) : MutableList<SessionParameter> by mutableListOf() {
    init { addAll(parameters) }
}

data class SessionParameter(
    val parameterId: SessionParameterId,
    val parameterValue: Any
)

sealed class SessionParameterId(
    val id: Int
) {
    object Coppa : SessionParameterId(0)
    object Voucher : SessionParameterId(1)
    object ParentEmailRequest : SessionParameterId(2)
    object ParentEmailRequestRegistration : SessionParameterId(3)
    object AllowDirectMail : SessionParameterId(4)
    object DateFormatter : SessionParameterId(5)
    object PartnerIntegration : SessionParameterId(6)
    object ProfileEditing : SessionParameterId(7)
    object TrackingHeader : SessionParameterId(8)
    object TutorialEnabled : SessionParameterId(9)
}