---
title: com.habbokt.page.client
---
//[page](../../index.html)/[com.habbokt.page.client](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [ClientPage](-client-page/index.html) | [jvm]<br>class [ClientPage](-client-page/index.html)@Injectconstructor(siteService: SiteService, playersService: PlayersService) : [Page](../com.habbokt.page/-page/index.html)&lt;[ClientPageRequest](-client-page-request/index.html)&gt; |
| [ClientPageRequest](-client-page-request/index.html) | [jvm]<br>data class [ClientPageRequest](-client-page-request/index.html)(val userSession: UserSession) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [ClientPageRouting](-client-page-routing/index.html) | [jvm]<br>class [ClientPageRouting](-client-page-routing/index.html)@Injectconstructor(service: [ClientPageService](-client-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [ClientPageService](-client-page-service/index.html) | [jvm]<br>class [ClientPageService](-client-page-service/index.html)@Injectconstructor(page: [ClientPage](-client-page/index.html)) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[ClientPageRequest](-client-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

