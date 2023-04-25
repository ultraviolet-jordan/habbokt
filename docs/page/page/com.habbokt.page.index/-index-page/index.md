---
title: IndexPage
---
//[page](../../../index.html)/[com.habbokt.page.index](../index.html)/[IndexPage](index.html)



# IndexPage

class [IndexPage](index.html)@Injectconstructor(siteService: SiteService) : [Page](../../com.habbokt.page/-page/index.html)&lt;[IndexPageRequest](../-index-page-request/index.html)&gt; 

#### Author



Jordan Abraham



#### See also


| |
|---|
| [IndexPageRequest](../-index-page-request/index.html) |
| [IndexPageRouting](../-index-page-routing/index.html) |
| [IndexPageService](../-index-page-service/index.html) |


## Constructors


| | |
|---|---|
| [IndexPage](-index-page.html) | [jvm]<br>@Inject<br>constructor(siteService: SiteService)<br>Injects the [siteService](../../../../page/com.habbokt.page.index/-index-page/[60]init[62].md) for pulling the latest website information from the database for this page [template](../../../../page/com.habbokt.page.index/-index-page/template.md). |


## Functions


| Name | Summary |
|---|---|
| [html](../../com.habbokt.page/html.html) | [jvm]<br>inline suspend fun &lt;[R](../../com.habbokt.page/html.html) : [PageRequest](../../com.habbokt.page/-page-request/index.html)&gt; [Page](../../com.habbokt.page/-page/index.html)&lt;[R](../../com.habbokt.page/html.html)&gt;.[html](../../com.habbokt.page/html.html)(request: [R](../../com.habbokt.page/html.html)): [Html](../../com.habbokt.page/-html/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](../../com.habbokt.page/-page/name.html) | [jvm]<br>val [name](../../com.habbokt.page/-page/name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The resources name of this page template file. |
| [template](../../com.habbokt.page/-page/template.html) | [jvm]<br>val [template](../../com.habbokt.page/-page/template.html): suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([IndexPageRequest](../-index-page-request/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The template builder for building the html of this page. |

