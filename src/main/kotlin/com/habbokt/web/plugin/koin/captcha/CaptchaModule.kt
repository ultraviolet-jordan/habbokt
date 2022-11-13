package com.habbokt.web.plugin.koin.captcha

import com.habbokt.web.page.captcha.CaptchaService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun captchaModule() = module(createdAtStart = true) {
    single { CaptchaService() }
}
