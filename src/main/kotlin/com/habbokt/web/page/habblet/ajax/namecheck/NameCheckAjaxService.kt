package com.habbokt.web.page.habblet.ajax.namecheck

import com.habbokt.web.common.htmlHeader
import com.habbokt.web.common.xjsonHeader
import com.habbokt.web.dao.players.PlayersDAO
import com.habbokt.web.inject
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond

/**
 * @author Jordan Abraham
 */
object NameCheckAjaxService {
    private val dao by inject<PlayersDAO>()

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
        dao.exists(username) -> NameCheckStatus.NameTaken // Check database for username.
        else -> NameCheckStatus.Successful
    }
}
