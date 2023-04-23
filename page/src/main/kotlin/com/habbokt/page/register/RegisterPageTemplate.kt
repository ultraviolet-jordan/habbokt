package com.habbokt.page.register

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

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
        site?.let { put("site", it) }
        put("randomNum", randomNum)
        registerCaptchaInvalid?.let { put("registerCaptchaInvalid", it) }
        registerEmailInvalid?.let { put("registerEmailInvalid", it) }
        registerUsername?.let { put("registerUsername", it) }
        registerShowPassword?.let { put("registerShowPassword", it) }
        registerEmail?.let { put("registerEmail", it) }
        registerDay?.let { put("registerDay", it) }
        registerMonth?.let { put("registerMonth", it) }
        registerYear?.let { put("registerYear", it) }
        registerFigure?.let { put("registerFigure", it) }
        registerGender?.let { put("registerGender", it) }
    }
)