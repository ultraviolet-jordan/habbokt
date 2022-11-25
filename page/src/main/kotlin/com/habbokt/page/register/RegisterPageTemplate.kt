package com.habbokt.page.register

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class RegisterPageTemplate(
    private val site: SiteDAO?,
    private val randomNum: String,
    private val registerCaptchaInvalid: Boolean?,
    private val registerEmailInvalid: Boolean?,
    private val registerUsername: String?,
    private val registerShowPassword: String?,
    private val registerEmail: String?,
    private val registerDay: String?,
    private val registerMonth: String?,
    private val registerYear: String?,
    private val registerFigure: String?,
    private val registerGender: String?
) : PageTemplate("register.tpl") {
    override fun configure() {
        bind("site" to site)
        bind("randomNum" to randomNum)
        bind("registerCaptchaInvalid" to registerCaptchaInvalid)
        bind("registerEmailInvalid" to registerEmailInvalid)
        bind("registerUsername" to registerUsername)
        bind("registerShowPassword" to registerShowPassword)
        bind("registerEmail" to registerEmail)
        bind("registerDay" to registerDay)
        bind("registerMonth" to registerMonth)
        bind("registerYear" to registerYear)
        bind("registerFigure" to registerFigure)
        bind("registerGender" to registerGender)
    }
}