package com.habbokt.web.page.captcha

import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun captchaModule() = module(createdAtStart = true) {
    single { CaptchaService() }
}