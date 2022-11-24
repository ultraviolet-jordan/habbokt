package com.habbokt.page

import com.habbokt.dao.DAOModule
import com.habbokt.page.asset.AssetPageRouting
import com.habbokt.page.index.IndexPage
import com.habbokt.page.index.IndexPageRouting
import com.habbokt.page.index.IndexPageService
import com.habbokt.page.index.IndexPageTemplate
import com.habbokt.page.me.MePage
import com.habbokt.page.me.MePageRouting
import com.habbokt.page.me.MePageService
import com.habbokt.page.me.MePageTemplate
import com.habbokt.templating.TemplatingModule
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder
import io.ktor.server.application.Application
import io.ktor.server.routing.Routing
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
class PageModule(
    private val application: Application
) : KotlinModule() {
    override fun configure() {
        install(DAOModule)
        install(TemplatingModule)

        bind<Routing>().toInstance(application.routing{})

        bind<Page<IndexPageTemplate>>().to<IndexPage>()
        bind<Page<MePageTemplate>>().to<MePage>()

        bind<PageService<IndexPage>>().to<IndexPageService<IndexPage>>()
        bind<PageService<MePage>>().to<MePageService<MePage>>()

        val routingBinder = KotlinMultibinder.newSetBinder<PageRouting>(binder())
        routingBinder.addBinding().to<AssetPageRouting>()
        routingBinder.addBinding().to<IndexPageRouting>()
        routingBinder.addBinding().to<MePageRouting>()
    }
}