package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import kotlin.random.Random

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPage @Inject constructor(
    private val siteService: SiteService
) : Page<RegisterPageTemplate, RegisterPageRequest>(
    template = {
        RegisterPageTemplate(
            site = siteService.site(),
            randomNum = Random.nextInt(0, 10000).toString(),
            registerCaptchaInvalid = badCaptcha,
            registerEmailInvalid = badEmail,
            registerUsername = username,
            registerShowPassword = password,
            registerEmail = email,
            registerDay = birthDay,
            registerMonth = birthMonth,
            registerYear = birthYear,
            registerFigure = appearance,
            registerGender = gender
        )
    }
)