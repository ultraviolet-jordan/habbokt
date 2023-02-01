package com.habbokt.page.register

import com.habbokt.page.PageRequest
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
data class RegisterPageRequest(
    val session: CurrentSession?,
    val badCaptcha: Boolean?,
    val badEmail: Boolean?,
    val username: String?,
    val password: String?,
    val email: String?,
    val birthDay: String?,
    val birthMonth: String?,
    val birthYear: String?,
    val appearance: String?,
    val gender: String?
) : PageRequest {
    companion object {
        val Empty = RegisterPageRequest(null, null, null, null, null, null, null, null, null, null, null)
    }
}