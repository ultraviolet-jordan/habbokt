---
title: com.habbokt.page.register
---
//[page](../../index.html)/[com.habbokt.page.register](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [RegisterPage](-register-page/index.html) | [jvm]<br>class [RegisterPage](-register-page/index.html)@Injectconstructor(siteService: SiteService) : [Page](../com.habbokt.page/-page/index.html)&lt;[RegisterPageRequest](-register-page-request/index.html)&gt; |
| [RegisterPageRequest](-register-page-request/index.html) | [jvm]<br>data class [RegisterPageRequest](-register-page-request/index.html)(val session: CurrentSession?, val badCaptcha: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, val badEmail: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, val username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val birthDay: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val birthMonth: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val birthYear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val appearance: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val gender: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [RegisterPageRouting](-register-page-routing/index.html) | [jvm]<br>class [RegisterPageRouting](-register-page-routing/index.html)@Injectconstructor(service: [RegisterPageService](-register-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [RegisterPageService](-register-page-service/index.html) | [jvm]<br>class [RegisterPageService](-register-page-service/index.html)@Injectconstructor(page: [RegisterPage](-register-page/index.html), playersService: PlayersService, argon2Service: Argon2Service) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[RegisterPageRequest](-register-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [Redirect](../com.habbokt.page/-redirect/index.html)&gt; |

