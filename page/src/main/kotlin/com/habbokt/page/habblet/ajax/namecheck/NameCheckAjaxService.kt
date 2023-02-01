package com.habbokt.page.habblet.ajax.namecheck

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.page.Ajax
import com.habbokt.page.BlankPageService
import com.habbokt.page.None
import com.habbokt.page.ajax

/**
 * @author Jordan Abraham
 */
@Singleton
class NameCheckAjaxService @Inject constructor(
    private val playersService: PlayersService
) : BlankPageService<NameCheckAjaxRequest, None, Ajax>(
    post = {
        ajax(
            """
            {"registration_name":"${playersService.checkStatus(name).string}"}
            """.trimIndent()
        )
    }
)

private suspend fun PlayersService.checkStatus(username: String?): NameCheckStatus = when {
    username == null -> NameCheckStatus.Empty
    exists(username) -> NameCheckStatus.NameTaken // Check database for username.
    else -> NameCheckStatus.Successful
}