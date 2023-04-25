---
title: ClientPageService
---
//[page](../../../index.html)/[com.habbokt.page.client](../index.html)/[ClientPageService](index.html)



# ClientPageService



[jvm]\
class [ClientPageService](index.html)@Injectconstructor(page: [ClientPage](../-client-page/index.html)) : [PageService](../../com.habbokt.page/-page-service/index.html)&lt;[ClientPageRequest](../-client-page-request/index.html), [Html](../../com.habbokt.page/-html/index.html), [None](../../com.habbokt.page/-none/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [ClientPageService](-client-page-service.html) | [jvm]<br>@Inject<br>constructor(page: [ClientPage](../-client-page/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [getRequest](index.html#1279005974%2FFunctions%2F317194267) | [jvm]<br>suspend fun [getRequest](index.html#1279005974%2FFunctions%2F317194267)(request: [ClientPageRequest](../-client-page-request/index.html)): [Html](../../com.habbokt.page/-html/index.html)<br>Handles the http GET request to this service if applicable. |
| [postRequest](index.html#-879616878%2FFunctions%2F317194267) | [jvm]<br>suspend fun [postRequest](index.html#-879616878%2FFunctions%2F317194267)(request: [ClientPageRequest](../-client-page-request/index.html)): [None](../../com.habbokt.page/-none/index.html)<br>Handles the http POST request to this service if applicable. |

