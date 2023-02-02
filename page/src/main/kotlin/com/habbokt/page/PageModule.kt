package com.habbokt.page

import com.habbokt.argon2.Argon2Module
import com.habbokt.dao.DAOModule
import com.habbokt.page.account.logout.AccountLogoutPageRouting
import com.habbokt.page.account.password.forgot.AccountPasswordForgotPageRouting
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
import io.ktor.client.HttpClient

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

        bind<HttpClient>().toProvider<HttpClientProvider>()

        with(KotlinMultibinder.newSetBinder<PageRouting>(kotlinBinder)) {
            // Account
            addBinding().to<AccountSubmitPageRouting>()
            addBinding().to<AccountLogoutPageRouting>()
            addBinding().to<AccountPasswordForgotPageRouting>()
            // Asset
            addBinding().to<AssetPageRouting>()
            // Captcha
            addBinding().to<CaptchaRouting>()
            // Client
            addBinding().to<ClientPageRouting>()
            // Export
            addBinding().to<ExportPageRouting>()
            // Habblet
            addBinding().to<NameCheckAjaxRouting>()
            // Habboimaging
            addBinding().to<AvatarImageRouting>()
            // Index
            addBinding().to<IndexPageRouting>()
            // Me
            addBinding().to<MePageRouting>()
            // Register
            addBinding().to<RegisterPageRouting>()
            // Security
            addBinding().to<SecurityCheckPageRouting>()
            // Test
            addBinding().to<TestPageRouting>()
            // Welcome
            addBinding().to<WelcomePageRouting>()
        }
    }
}