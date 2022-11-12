package com.habbokt.web

import com.habbokt.web.page.asset.installAssetsRoutes
import com.habbokt.web.page.error.installErrorPageRoutes
import com.habbokt.web.page.index.installIndexPageRoutes
import com.habbokt.web.page.register.installRegisterPageRoutes
import com.habbokt.web.plugin.installCallLoggingPlugin
import com.habbokt.web.plugin.installKoinPlugin
import com.habbokt.web.plugin.installStatusPagesPlugin
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import org.koin.mp.KoinPlatformTools

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    // Install web-server plugins.
    installKoinPlugin()
    installStatusPagesPlugin()
    installCallLoggingPlugin()

    // Install web-server routes.
    installAssetsRoutes()
    installIndexPageRoutes()
    installRegisterPageRoutes()
    installErrorPageRoutes()
}

inline fun <reified T : Any> inject(): Lazy<T> = KoinPlatformTools.defaultContext().get().inject(null, KoinPlatformTools.defaultLazyMode(), null)
