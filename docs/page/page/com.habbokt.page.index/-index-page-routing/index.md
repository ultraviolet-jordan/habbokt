---
title: IndexPageRouting
---
//[page](../../../index.html)/[com.habbokt.page.index](../index.html)/[IndexPageRouting](index.html)



# IndexPageRouting

class [IndexPageRouting](index.html)@Injectconstructor(service: [IndexPageService](../-index-page-service/index.html)) : [PageRouting](../../com.habbokt.page/-page-routing/index.html)

<b>Information</b>

```kotlin
GET {host}/
QUERY page
QUERY rememberme
QUERY username
```


<b>Example</b>

```kotlin
http://localhost/?page=submit&username=jordan&rememberme=true
```


#### Author



Jordan Abraham



#### See also


| |
|---|
| [IndexPage](../-index-page/index.html) |
| [IndexPageRequest](../-index-page-request/index.html) |
| [IndexPageService](../-index-page-service/index.html) |


## Constructors


| | |
|---|---|
| [IndexPageRouting](-index-page-routing.html) | [jvm]<br>@Inject<br>constructor(service: [IndexPageService](../-index-page-service/index.html))<br>Injects the associated [service](../../../../page/com.habbokt.page.index/-index-page-routing/[60]init[62].md) for handling the request set by the [routing](../../../../page/com.habbokt.page.index/-index-page-routing/routing.md). |


## Properties


| Name | Summary |
|---|---|
| [routing](../../com.habbokt.page/-page-routing/routing.html) | [jvm]<br>val [routing](../../com.habbokt.page/-page-routing/routing.html): Routing.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The routing used for the http requests for a html page. |

