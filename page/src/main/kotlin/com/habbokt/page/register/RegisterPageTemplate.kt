package com.habbokt.page.register

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class RegisterPageTemplate(
    site: SiteDAO,
    randomNum: String,
    registerCaptchaInvalid: Boolean?,
    registerEmailInvalid: Boolean?,
    registerUsername: String?,
    registerShowPassword: String?,
    registerEmail: String?,
    registerDay: String?,
    registerMonth: String?,
    registerYear: String?,
    registerFigure: String?,
    registerGender: String?
) : BaseTemplate(path = "register.tpl", site) {
    init {
        this["randomNum"] to randomNum
        this["registerCaptchaInvalid"] to registerCaptchaInvalid
        this["registerEmailInvalid"] to registerEmailInvalid
        this["registerUsername"] to registerUsername
        this["registerShowPassword"] to registerShowPassword
        this["registerEmail"] to registerEmail
        this["registerDay"] to registerDay
        this["registerMonth"] to registerMonth
        this["registerYear"] to registerYear
        this["registerFigure"] to registerFigure
        this["registerGender"] to registerGender
    }
}