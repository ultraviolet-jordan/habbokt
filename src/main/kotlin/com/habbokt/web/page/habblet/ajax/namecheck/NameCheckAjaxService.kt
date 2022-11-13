package com.habbokt.web.page.habblet.ajax.namecheck

import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters

/**
 * @author Jordan Abraham
 */
class NameCheckAjaxService {
    suspend fun getNameCheckFormResponse(call: ApplicationCall): NameCheckStatus = checkUsernameIsValid(call.receiveParameters()["name"])

    private fun checkUsernameIsValid(username: String?): NameCheckStatus = when (username) {
        null -> NameCheckStatus.Empty
        else -> NameCheckStatus.Successful
    }
}
