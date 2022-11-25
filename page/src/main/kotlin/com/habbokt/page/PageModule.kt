package com.habbokt.page

import com.habbokt.dao.DAOModule
import com.habbokt.page.asset.AssetPageRouting
import com.habbokt.page.habblet.ajax.namecheck.NameCheckAjaxRouting
import com.habbokt.page.index.IndexPageRouting
import com.habbokt.page.me.MePageRouting
import com.habbokt.page.register.RegisterPageRouting
import com.habbokt.page.test.TestPageRouting
import com.habbokt.templating.TemplatingModule
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder

/**
 * @author Jordan Abraham
 */
object PageModule : KotlinModule() {
    override fun configure() {
        install(DAOModule)
        install(TemplatingModule)

        val routes = KotlinMultibinder.newSetBinder<PageRouting>(binder())
        routes.addBinding().to<AssetPageRouting>()
        routes.addBinding().to<IndexPageRouting>()
        routes.addBinding().to<MePageRouting>()
        routes.addBinding().to<RegisterPageRouting>()
        routes.addBinding().to<NameCheckAjaxRouting>()
        routes.addBinding().to<TestPageRouting>()
    }
}