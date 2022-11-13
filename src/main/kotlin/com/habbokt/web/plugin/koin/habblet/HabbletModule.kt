package com.habbokt.web.plugin.koin.habblet

import com.habbokt.web.page.habblet.ajax.namecheck.NameCheckAjaxService
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun habbletModule() = module(createdAtStart = true) {
    single { NameCheckAjaxService() }
}
