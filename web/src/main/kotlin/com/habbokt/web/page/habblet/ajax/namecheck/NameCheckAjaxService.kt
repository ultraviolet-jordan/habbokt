package com.habbokt.web.page.habblet.ajax.namecheck

import com.habbokt.api.inject
import com.habbokt.dao.players.PlayersService
import com.habbokt.web.htmlHeader
import com.habbokt.web.xjsonHeader
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond

/**
 * @author Jordan Abraham
 */
object NameCheckAjaxService {
    private val playersService by inject<PlayersService>()

    suspend fun respondNameCheck(call: ApplicationCall) {
        val response = checkUsernameIsValid(call.receiveParameters()["name"])
        // Respond back with the xjson body of the name check.
        call.apply {
            xjsonHeader(
                """
                    {"registration_name":"${response.string}"}
                """.trimIndent()
            )
            htmlHeader(0)
        }.respond(HttpStatusCode.OK)
    }

    private suspend fun checkUsernameIsValid(username: String?): NameCheckStatus = when {
        username == null -> NameCheckStatus.Empty
        playersService.exists(username) -> NameCheckStatus.NameTaken // Check database for username.
        else -> NameCheckStatus.Successful
    }
}
