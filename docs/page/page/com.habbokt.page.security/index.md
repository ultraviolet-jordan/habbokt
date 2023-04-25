---
title: com.habbokt.page.security
---
//[page](../../index.html)/[com.habbokt.page.security](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [SecurityCheckPage](-security-check-page/index.html) | [jvm]<br>class [SecurityCheckPage](-security-check-page/index.html)@Injectconstructor(siteService: SiteService) : [Page](../com.habbokt.page/-page/index.html)&lt;[SecurityCheckPageRequest](-security-check-page-request/index.html)&gt; |
| [SecurityCheckPageRequest](-security-check-page-request/index.html) | [jvm]<br>data class [SecurityCheckPageRequest](-security-check-page-request/index.html)(val redirectPath: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [SecurityCheckPageRouting](-security-check-page-routing/index.html) | [jvm]<br>class [SecurityCheckPageRouting](-security-check-page-routing/index.html)@Injectconstructor(service: [SecurityCheckPageService](-security-check-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [SecurityCheckPageService](-security-check-page-service/index.html) | [jvm]<br>class [SecurityCheckPageService](-security-check-page-service/index.html)@Injectconstructor(page: [SecurityCheckPage](-security-check-page/index.html)) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[SecurityCheckPageRequest](-security-check-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

