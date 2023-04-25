---
title: com.habbokt.page.help
---
//[page](../../index.html)/[com.habbokt.page.help](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [FaqPage](-faq-page/index.html) | [jvm]<br>class [FaqPage](-faq-page/index.html)@Injectconstructor(siteService: SiteService, playersService: PlayersService) : [Page](../com.habbokt.page/-page/index.html)&lt;[FaqPageRequest](-faq-page-request/index.html)&gt; |
| [FaqPageRequest](-faq-page-request/index.html) | [jvm]<br>data class [FaqPageRequest](-faq-page-request/index.html)(val helpId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, val userId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [FaqPageRouting](-faq-page-routing/index.html) | [jvm]<br>class [FaqPageRouting](-faq-page-routing/index.html)@Injectconstructor(service: [FaqPageService](-faq-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [FaqPageService](-faq-page-service/index.html) | [jvm]<br>class [FaqPageService](-faq-page-service/index.html)@Injectconstructor(page: [FaqPage](-faq-page/index.html)) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[FaqPageRequest](-faq-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

