---
title: com.habbokt.page.index
---
//[page](../../index.html)/[com.habbokt.page.index](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [IndexPage](-index-page/index.html) | [jvm]<br>class [IndexPage](-index-page/index.html)@Injectconstructor(siteService: SiteService) : [Page](../com.habbokt.page/-page/index.html)&lt;[IndexPageRequest](-index-page-request/index.html)&gt; |
| [IndexPageRequest](-index-page-request/index.html) | [jvm]<br>data class [IndexPageRequest](-index-page-request/index.html)(val rememberMe: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [PageRequest](../com.habbokt.page/-page-request/index.html)<br><b>Example</b> |
| [IndexPageRouting](-index-page-routing/index.html) | [jvm]<br>class [IndexPageRouting](-index-page-routing/index.html)@Injectconstructor(service: [IndexPageService](-index-page-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html)<br><b>Information</b> |
| [IndexPageService](-index-page-service/index.html) | [jvm]<br>class [IndexPageService](-index-page-service/index.html)@Injectconstructor(page: [IndexPage](-index-page/index.html)) : [PageService](../com.habbokt.page/-page-service/index.html)&lt;[IndexPageRequest](-index-page-request/index.html), [Html](../com.habbokt.page/-html/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

