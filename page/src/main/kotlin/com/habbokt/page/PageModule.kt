package com.habbokt.page

import com.habbokt.argon2.Argon2Module
import com.habbokt.dao.DAOModule
import com.habbokt.page.account.submit.AccountSubmitPageRouting
import com.habbokt.page.asset.AssetPageRouting
import com.habbokt.page.captcha.CaptchaRouting
import com.habbokt.page.client.ClientPageRouting
import com.habbokt.page.export.ExportPageRouting
import com.habbokt.page.habblet.ajax.namecheck.NameCheckAjaxRouting
import com.habbokt.page.habboimaging.avatarimage.AvatarImageRouting
import com.habbokt.page.index.IndexPageRouting
import com.habbokt.page.me.MePageRouting
import com.habbokt.page.register.RegisterPageRouting
import com.habbokt.page.security.SecurityCheckPageRouting
import com.habbokt.page.test.TestPageRouting
import com.habbokt.page.welcome.WelcomePageRouting
import com.habbokt.swf.SwfModule
import com.habbokt.templating.TemplatingModule
import com.habbokt.xml.XMLModule
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder

/**
 * @author Jordan Abraham
 */
object PageModule : KotlinModule() {
    override fun configure() {
        install(Argon2Module)
        install(DAOModule)
        install(SwfModule)
        install(TemplatingModule)
        install(XMLModule)

        val routes = KotlinMultibinder.newSetBinder<PageRouting>(kotlinBinder)
        // Account
        routes.addBinding().to<AccountSubmitPageRouting>()
        // Asset
        routes.addBinding().to<AssetPageRouting>()
        // Captcha
        routes.addBinding().to<CaptchaRouting>()
        // Client
        routes.addBinding().to<ClientPageRouting>()
        // Export
        routes.addBinding().to<ExportPageRouting>()
        // Habblet
        routes.addBinding().to<NameCheckAjaxRouting>()
        // Habboimaging
        routes.addBinding().to<AvatarImageRouting>()
        // Index
        routes.addBinding().to<IndexPageRouting>()
        // Me
        routes.addBinding().to<MePageRouting>()
        // Register
        routes.addBinding().to<RegisterPageRouting>()
        // Security
        routes.addBinding().to<SecurityCheckPageRouting>()
        // Test
        routes.addBinding().to<TestPageRouting>()
        // Welcome
        routes.addBinding().to<WelcomePageRouting>()
    }
}