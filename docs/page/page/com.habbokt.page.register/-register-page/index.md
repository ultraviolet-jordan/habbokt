---
title: RegisterPage
---
//[page](../../../index.html)/[com.habbokt.page.register](../index.html)/[RegisterPage](index.html)



# RegisterPage



[jvm]\
class [RegisterPage](index.html)@Injectconstructor(siteService: SiteService) : [Page](../../com.habbokt.page/-page/index.html)&lt;[RegisterPageRequest](../-register-page-request/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [RegisterPage](-register-page.html) | [jvm]<br>@Inject<br>constructor(siteService: SiteService) |


## Functions


| Name | Summary |
|---|---|
| [html](../../com.habbokt.page/html.html) | [jvm]<br>inline suspend fun &lt;[R](../../com.habbokt.page/html.html) : [PageRequest](../../com.habbokt.page/-page-request/index.html)&gt; [Page](../../com.habbokt.page/-page/index.html)&lt;[R](../../com.habbokt.page/html.html)&gt;.[html](../../com.habbokt.page/html.html)(request: [R](../../com.habbokt.page/html.html)): [Html](../../com.habbokt.page/-html/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](../../com.habbokt.page/-page/name.html) | [jvm]<br>val [name](../../com.habbokt.page/-page/name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The resources name of this page template file. |
| [template](../../com.habbokt.page/-page/template.html) | [jvm]<br>val [template](../../com.habbokt.page/-page/template.html): suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([RegisterPageRequest](../-register-page-request/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The template builder for building the html of this page. |

