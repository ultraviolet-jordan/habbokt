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
import com.habbokt.page.help.FaqPageRouting
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

        KotlinMultibinder.newSetBinder<PageRouting>(kotlinBinder).apply {
            bindRouting<AccountSubmitPageRouting>()
            bindRouting<AccountLogoutPageRouting>()
            bindRouting<AccountPasswordForgotPageRouting>()
            bindRouting<AssetPageRouting>()
            bindRouting<CaptchaRouting>()
            bindRouting<ClientPageRouting>()
            bindRouting<ExportPageRouting>()
            bindRouting<NameCheckAjaxRouting>()
            bindRouting<AvatarImageRouting>()
            bindRouting<FaqPageRouting>()
            bindRouting<IndexPageRouting>()
            bindRouting<MePageRouting>()
            bindRouting<RegisterPageRouting>()
            bindRouting<SecurityCheckPageRouting>()
            bindRouting<TestPageRouting>()
            bindRouting<WelcomePageRouting>()
        }
    }

    private inline fun <reified P : PageRouting> KotlinMultibinder<PageRouting>.bindRouting() {
        addBinding().to<P>()
    }
}