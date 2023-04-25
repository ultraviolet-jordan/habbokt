---
title: PageService
---
//[page](../../../index.html)/[com.habbokt.page](../index.html)/[PageService](index.html)



# PageService

abstract class [PageService](index.html)&lt;[R](index.html) : [PageRequest](../-page-request/index.html), [G](index.html) : [ResponseType](../-response-type/index.html), [P](index.html) : [ResponseType](../-response-type/index.html)&gt;(get: suspend [R](index.html).() -&gt; [G](index.html)? = null, post: suspend [R](index.html).() -&gt; [P](index.html)? = null)

#### Author



Jordan Abraham



#### See also


| |
|---|
| [Page](../-page/index.html) |
| [PageRequest](../-page-request/index.html) |
| [PageRouting](../-page-routing/index.html) |
| [ResponseType](../-response-type/index.html) |


#### Inheritors


| |
|---|
| [BlankPageService](../-blank-page-service/index.html) |
| [AccountLogoutPageService](../../com.habbokt.page.account.logout/-account-logout-page-service/index.html) |
| [AccountPasswordForgotPageService](../../com.habbokt.page.account.password.forgot/-account-password-forgot-page-service/index.html) |
| [AccountSubmitPageService](../../com.habbokt.page.account.submit/-account-submit-page-service/index.html) |
| [ClientPageService](../../com.habbokt.page.client/-client-page-service/index.html) |
| [FaqPageService](../../com.habbokt.page.help/-faq-page-service/index.html) |
| [IndexPageService](../../com.habbokt.page.index/-index-page-service/index.html) |
| [MePageService](../../com.habbokt.page.me/-me-page-service/index.html) |
| [RegisterPageService](../../com.habbokt.page.register/-register-page-service/index.html) |
| [SecurityCheckPageService](../../com.habbokt.page.security/-security-check-page-service/index.html) |
| [WelcomePageService](../../com.habbokt.page.welcome/-welcome-page-service/index.html) |


## Constructors


| | |
|---|---|
| [PageService](-page-service.html) | [jvm]<br>constructor(get: suspend [R](index.html).() -&gt; [G](index.html)? = null, post: suspend [R](index.html).() -&gt; [P](index.html)? = null) |


## Functions


| Name | Summary |
|---|---|
| [getRequest](get-request.html) | [jvm]<br>suspend fun [getRequest](get-request.html)(request: [R](index.html)): [G](index.html)<br>Handles the http GET request to this service if applicable. |
| [postRequest](post-request.html) | [jvm]<br>suspend fun [postRequest](post-request.html)(request: [R](index.html)): [P](index.html)<br>Handles the http POST request to this service if applicable. |

