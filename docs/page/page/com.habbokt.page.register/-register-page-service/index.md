---
title: RegisterPageService
---
//[page](../../../index.html)/[com.habbokt.page.register](../index.html)/[RegisterPageService](index.html)



# RegisterPageService



[jvm]\
class [RegisterPageService](index.html)@Injectconstructor(page: [RegisterPage](../-register-page/index.html), playersService: PlayersService, argon2Service: Argon2Service) : [PageService](../../com.habbokt.page/-page-service/index.html)&lt;[RegisterPageRequest](../-register-page-request/index.html), [Html](../../com.habbokt.page/-html/index.html), [Redirect](../../com.habbokt.page/-redirect/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [RegisterPageService](-register-page-service.html) | [jvm]<br>@Inject<br>constructor(page: [RegisterPage](../-register-page/index.html), playersService: PlayersService, argon2Service: Argon2Service) |


## Functions


| Name | Summary |
|---|---|
| [getRequest](index.html#982714326%2FFunctions%2F317194267) | [jvm]<br>suspend fun [getRequest](index.html#982714326%2FFunctions%2F317194267)(request: [RegisterPageRequest](../-register-page-request/index.html)): [Html](../../com.habbokt.page/-html/index.html)<br>Handles the http GET request to this service if applicable. |
| [postRequest](index.html#-2006912686%2FFunctions%2F317194267) | [jvm]<br>suspend fun [postRequest](index.html#-2006912686%2FFunctions%2F317194267)(request: [RegisterPageRequest](../-register-page-request/index.html)): [Redirect](../../com.habbokt.page/-redirect/index.html)<br>Handles the http POST request to this service if applicable. |

