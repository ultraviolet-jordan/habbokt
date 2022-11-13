package com.habbokt.web.plugin.authentication

/**
 * @author Jordan Abraham
 */
sealed class Authentications {
    companion object {
        const val Captcha = "captcha_session"
        const val User = "user_session"
    }
}
