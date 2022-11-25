package com.habbokt.page.habblet.ajax.namecheck

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receiveParameters

/**
 * @author Jordan Abraham
 */
@Singleton
class NameCheckAjaxService @Inject constructor(
    page: BlankPage,
    private val playersService: PlayersService
) : BlankPageService(page) {
    override suspend fun handlePostRequest(call: ApplicationCall) {
        val response = checkUsernameIsValid(call.receiveParameters()["name"])
        // Respond back with the xjson body of the name check.
        call.respondAjax(
            """
            {"registration_name":"${response.string}"}
            """.trimIndent()
        )
    }

    private suspend fun checkUsernameIsValid(username: String?): NameCheckStatus = when {
        username == null -> NameCheckStatus.Empty
        playersService.exists(username) -> NameCheckStatus.NameTaken // Check database for username.
        else -> NameCheckStatus.Successful
    }
}