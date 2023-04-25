---
title: IndexPageRequest
---
//[page](../../../index.html)/[com.habbokt.page.index](../index.html)/[IndexPageRequest](index.html)



# IndexPageRequest

data class [IndexPageRequest](index.html)(val rememberMe: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [PageRequest](../../com.habbokt.page/-page-request/index.html)

<b>Example</b>

```kotlin
IndexPageRequest(rememberMe = true, username = "jordan")
```


#### Author



Jordan Abraham



#### See also


| |
|---|
| [IndexPage](../-index-page/index.html) |
| [IndexPageRouting](../-index-page-routing/index.html) |
| [IndexPageService](../-index-page-service/index.html) |


## Constructors


| | |
|---|---|
| [IndexPageRequest](-index-page-request.html) | [jvm]<br>constructor(rememberMe: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)<br>Creates a new [PageRequest](../../com.habbokt.page/-page-request/index.html). |


## Properties


| Name | Summary |
|---|---|
| [rememberMe](remember-me.html) | [jvm]<br>val [rememberMe](remember-me.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) whether if this page attempted login with the &quot;Remember me&quot; option checked. |
| [username](username.html) | [jvm]<br>val [username](username.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>A [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) of the attempted login username on this page. |

