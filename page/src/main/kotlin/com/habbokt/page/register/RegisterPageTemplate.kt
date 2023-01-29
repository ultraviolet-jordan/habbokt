package com.habbokt.page.register

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class RegisterPageTemplate(
    site: SiteDAO?,
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
) : PageTemplate(
    path = "register.tpl",
    configuration = {
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
)