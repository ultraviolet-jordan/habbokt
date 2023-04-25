---
title: com.habbokt.page.me
---
//[page](../../index.html)/[com.habbokt.page.me](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [MePage](-me-page/index.html) | [jvm]<br>class [MePage](-me-page/index.html)@Injectconstructor(siteService: SiteService, playersService: PlayersService) : [Page](../com.habbokt.page/-page/index.html)&lt;[MePageRequest](-me-page-request/index.html)&gt; |
| [MePageRequest](-me-page-request/index.html) | [jvm]<br>data class [MePageRequest](-me-page-request/index.html)(val userId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [MePageRouting](-me-page-routing/index.html) | [jvm]<br>class [MePageRouting](-me-page-routing/index.html)@Injectconstructor(service: [MePageService](-me-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [MePageService](-me-page-service/index.html) | [jvm]<br>class [MePageService](-me-page-service/index.html)@Injectconstructor(page: [MePage](-me-page/index.html)) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[MePageRequest](-me-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

