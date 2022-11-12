package com.habbokt

import com.habbokt.asset.installAssets
import com.habbokt.compiler.compilerModule
import com.habbokt.page.index.indexPageModule
import com.habbokt.page.index.installIndexPage
import com.habbokt.model.Site
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import org.koin.ktor.plugin.Koin
import org.koin.mp.KoinPlatformTools

/**
 * @author Jordan Abraham
 */
fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    val site = Site(
        siteName = "Habbo Hotel",
        staticContentPath = "http://localhost"
    )

    install(Koin) {
        modules(
            compilerModule(),
            indexPageModule(site)
        )
    }

    installAssets()
    installIndexPage()
}

inline fun <reified T : Any> inject(): Lazy<T> = KoinPlatformTools.defaultContext().get().inject(null, KoinPlatformTools.defaultLazyMode(), null)
