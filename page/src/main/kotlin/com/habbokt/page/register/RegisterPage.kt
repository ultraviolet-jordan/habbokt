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
) : Page<RegisterPageRequest>(
    name = "register.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }

        put("randomNum", Random.nextInt(0, 10000).toString())

        it.badCaptcha?.let { badCaptcha ->
            put("registerCaptchaInvalid", badCaptcha)
        }

        it.badEmail?.let { badEmail ->
            put("registerEmailInvalid", badEmail)
        }

        it.username?.let { username ->
            put("registerUsername", username)
        }

        it.password?.let { password ->
            put("registerShowPassword", password)
        }

        it.email?.let { email ->
            put("registerEmail", email)
        }

        it.birthDay?.let { birthDay ->
            put("registerDay", birthDay)
        }

        it.birthMonth?.let { birthMonth ->
            put("registerMonth", birthMonth)
        }

        it.birthYear?.let { birthYear ->
            put("registerYear", birthYear)
        }

        it.appearance?.let { appearance ->
            put("registerFigure", appearance)
        }

        it.gender?.let { gender ->
            put("registerGender", gender)
        }
    }
)