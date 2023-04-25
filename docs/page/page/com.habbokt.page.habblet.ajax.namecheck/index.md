---
title: com.habbokt.page.habblet.ajax.namecheck
---
//[page](../../index.html)/[com.habbokt.page.habblet.ajax.namecheck](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [NameCheckAjaxRequest](-name-check-ajax-request/index.html) | [jvm]<br>data class [NameCheckAjaxRequest](-name-check-ajax-request/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [NameCheckAjaxRouting](-name-check-ajax-routing/index.html) | [jvm]<br>class [NameCheckAjaxRouting](-name-check-ajax-routing/index.html)@Injectconstructor(service: [NameCheckAjaxService](-name-check-ajax-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [NameCheckAjaxService](-name-check-ajax-service/index.html) | [jvm]<br>class [NameCheckAjaxService](-name-check-ajax-service/index.html)@Injectconstructor(playersService: PlayersService) : [BlankPageService](../com.habbokt.page/-blank-page-service/index.html)&lt;[NameCheckAjaxRequest](-name-check-ajax-request/index.html), [None](../com.habbokt.page/-none/index.html), [Ajax](../com.habbokt.page/-ajax/index.html)&gt; |
| [NameCheckStatus](-name-check-status/index.html) | [jvm]<br>sealed class [NameCheckStatus](-name-check-status/index.html) |

