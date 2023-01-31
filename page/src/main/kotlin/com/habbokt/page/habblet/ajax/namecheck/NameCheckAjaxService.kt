package com.habbokt.page.habblet.ajax.namecheck

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.BlankPageService
import com.habbokt.page.respondAjax
import io.ktor.server.request.receiveParameters

/**
 * @author Jordan Abraham
 */
@Singleton
class NameCheckAjaxService @Inject constructor(
    private val playersService: PlayersService
) : BlankPageService(
    post = {
        // Respond back with the xjson body of the name check.
        respondAjax(
            """
            {"registration_name":"${playersService.checkUsernameIsValid(receiveParameters()["name"]).string}"}
            """.trimIndent()
        )
    }
)

private suspend fun PlayersService.checkUsernameIsValid(username: String?): NameCheckStatus = when {
    username == null -> NameCheckStatus.Empty
    exists(username) -> NameCheckStatus.NameTaken // Check database for username.
    else -> NameCheckStatus.Successful
}