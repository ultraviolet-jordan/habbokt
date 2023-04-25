---
title: MePage
---
//[page](../../../index.html)/[com.habbokt.page.me](../index.html)/[MePage](index.html)



# MePage



[jvm]\
class [MePage](index.html)@Injectconstructor(siteService: SiteService, playersService: PlayersService) : [Page](../../com.habbokt.page/-page/index.html)&lt;[MePageRequest](../-me-page-request/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [MePage](-me-page.html) | [jvm]<br>@Inject<br>constructor(siteService: SiteService, playersService: PlayersService) |


## Functions


| Name | Summary |
|---|---|
| [html](../../com.habbokt.page/html.html) | [jvm]<br>inline suspend fun &lt;[R](../../com.habbokt.page/html.html) : [PageRequest](../../com.habbokt.page/-page-request/index.html)&gt; [Page](../../com.habbokt.page/-page/index.html)&lt;[R](../../com.habbokt.page/html.html)&gt;.[html](../../com.habbokt.page/html.html)(request: [R](../../com.habbokt.page/html.html)): [Html](../../com.habbokt.page/-html/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](../../com.habbokt.page/-page/name.html) | [jvm]<br>val [name](../../com.habbokt.page/-page/name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The resources name of this page template file. |
| [template](../../com.habbokt.page/-page/template.html) | [jvm]<br>val [template](../../com.habbokt.page/-page/template.html): suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([MePageRequest](../-me-page-request/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The template builder for building the html of this page. |

