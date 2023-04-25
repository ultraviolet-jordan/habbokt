---
title: AccountSubmitPageService
---
//[page](../../../index.html)/[com.habbokt.page.account.submit](../index.html)/[AccountSubmitPageService](index.html)



# AccountSubmitPageService



[jvm]\
class [AccountSubmitPageService](index.html)@Injectconstructor(playersService: PlayersService, argon2Service: Argon2Service) : [PageService](../../com.habbokt.page/-page-service/index.html)&lt;[AccountSubmitPageRequest](../-account-submit-page-request/index.html), [None](../../com.habbokt.page/-none/index.html), [Redirect](../../com.habbokt.page/-redirect/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [AccountSubmitPageService](-account-submit-page-service.html) | [jvm]<br>@Inject<br>constructor(playersService: PlayersService, argon2Service: Argon2Service) |


## Functions


| Name | Summary |
|---|---|
| [getRequest](index.html#1221119658%2FFunctions%2F317194267) | [jvm]<br>suspend fun [getRequest](index.html#1221119658%2FFunctions%2F317194267)(request: [AccountSubmitPageRequest](../-account-submit-page-request/index.html)): [None](../../com.habbokt.page/-none/index.html)<br>Handles the http GET request to this service if applicable. |
| [postRequest](index.html#-1301586002%2FFunctions%2F317194267) | [jvm]<br>suspend fun [postRequest](index.html#-1301586002%2FFunctions%2F317194267)(request: [AccountSubmitPageRequest](../-account-submit-page-request/index.html)): [Redirect](../../com.habbokt.page/-redirect/index.html)<br>Handles the http POST request to this service if applicable. |

