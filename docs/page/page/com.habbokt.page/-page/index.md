---
title: Page
---
//[page](../../../index.html)/[com.habbokt.page](../index.html)/[Page](index.html)



# Page

abstract class [Page](index.html)&lt;[R](index.html) : [PageRequest](../-page-request/index.html)&gt;(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val template: suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([R](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

#### Author



Jordan Abraham



#### See also


| |
|---|
| [PageRequest](../-page-request/index.html) |
| [PageRouting](../-page-routing/index.html) |
| [PageService](../-page-service/index.html) |


#### Inheritors


| |
|---|
| [AccountLogoutPage](../../com.habbokt.page.account.logout/-account-logout-page/index.html) |
| [AccountPasswordForgotPage](../../com.habbokt.page.account.password.forgot/-account-password-forgot-page/index.html) |
| [AccountSubmitPage](../../com.habbokt.page.account.submit/-account-submit-page/index.html) |
| [ClientPage](../../com.habbokt.page.client/-client-page/index.html) |
| [FaqPage](../../com.habbokt.page.help/-faq-page/index.html) |
| [IndexPage](../../com.habbokt.page.index/-index-page/index.html) |
| [MePage](../../com.habbokt.page.me/-me-page/index.html) |
| [RegisterPage](../../com.habbokt.page.register/-register-page/index.html) |
| [SecurityCheckPage](../../com.habbokt.page.security/-security-check-page/index.html) |
| [WelcomePage](../../com.habbokt.page.welcome/-welcome-page/index.html) |


## Constructors


| | |
|---|---|
| [Page](-page.html) | [jvm]<br>constructor(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), template: suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([R](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [html](../html.html) | [jvm]<br>inline suspend fun &lt;[R](../html.html) : [PageRequest](../-page-request/index.html)&gt; [Page](index.html)&lt;[R](../html.html)&gt;.[html](../html.html)(request: [R](../html.html)): [Html](../-html/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](name.html) | [jvm]<br>val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The resources name of this page template file. |
| [template](template.html) | [jvm]<br>val [template](template.html): suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([R](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The template builder for building the html of this page. |

