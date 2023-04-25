---
title: com.habbokt.page.account.submit
---
//[page](../../index.html)/[com.habbokt.page.account.submit](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [AccountSubmitPage](-account-submit-page/index.html) | [jvm]<br>class [AccountSubmitPage](-account-submit-page/index.html)@Injectconstructor(siteService: SiteService) : [Page](../com.habbokt.page/-page/index.html)&lt;[AccountSubmitPageRequest](-account-submit-page-request/index.html)&gt; |
| [AccountSubmitPageRequest](-account-submit-page-request/index.html) | [jvm]<br>data class [AccountSubmitPageRequest](-account-submit-page-request/index.html)(val session: CurrentSession, val username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val rememberMe: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [AccountSubmitPageRouting](-account-submit-page-routing/index.html) | [jvm]<br>class [AccountSubmitPageRouting](-account-submit-page-routing/index.html)@Injectconstructor(service: [AccountSubmitPageService](-account-submit-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [AccountSubmitPageService](-account-submit-page-service/index.html) | [jvm]<br>class [AccountSubmitPageService](-account-submit-page-service/index.html)@Injectconstructor(playersService: PlayersService, argon2Service: Argon2Service) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[AccountSubmitPageRequest](-account-submit-page-request/index.html), [None](../com.habbokt.page/-none/index.html), [Redirect](../com.habbokt.page/-redirect/index.html)&gt; |

