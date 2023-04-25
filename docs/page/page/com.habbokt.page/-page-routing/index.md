---
title: PageRouting
---
//[page](../../../index.html)/[com.habbokt.page](../index.html)/[PageRouting](index.html)



# PageRouting

abstract class [PageRouting](index.html)(val routing: Routing.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

#### Author



Jordan Abraham



#### See also


| |
|---|
| [Page](../-page/index.html) |
| [PageRequest](../-page-request/index.html) |
| [PageService](../-page-service/index.html) |


#### Inheritors


| |
|---|
| [AccountLogoutPageRouting](../../com.habbokt.page.account.logout/-account-logout-page-routing/index.html) |
| [AccountPasswordForgotPageRouting](../../com.habbokt.page.account.password.forgot/-account-password-forgot-page-routing/index.html) |
| [AccountSubmitPageRouting](../../com.habbokt.page.account.submit/-account-submit-page-routing/index.html) |
| [AssetPageRouting](../../com.habbokt.page.asset/-asset-page-routing/index.html) |
| [CaptchaRouting](../../com.habbokt.page.captcha/-captcha-routing/index.html) |
| [ClientPageRouting](../../com.habbokt.page.client/-client-page-routing/index.html) |
| [ExportPageRouting](../../com.habbokt.page.export/-export-page-routing/index.html) |
| [NameCheckAjaxRouting](../../com.habbokt.page.habblet.ajax.namecheck/-name-check-ajax-routing/index.html) |
| [AvatarImageRouting](../../com.habbokt.page.habboimaging.avatarimage/-avatar-image-routing/index.html) |
| [FaqPageRouting](../../com.habbokt.page.help/-faq-page-routing/index.html) |
| [IndexPageRouting](../../com.habbokt.page.index/-index-page-routing/index.html) |
| [MePageRouting](../../com.habbokt.page.me/-me-page-routing/index.html) |
| [RegisterPageRouting](../../com.habbokt.page.register/-register-page-routing/index.html) |
| [SecurityCheckPageRouting](../../com.habbokt.page.security/-security-check-page-routing/index.html) |
| [TestPageRouting](../../com.habbokt.page.test/-test-page-routing/index.html) |
| [WelcomePageRouting](../../com.habbokt.page.welcome/-welcome-page-routing/index.html) |


## Constructors


| | |
|---|---|
| [PageRouting](-page-routing.html) | [jvm]<br>constructor(routing: Routing.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Creates a new Routing for a specified html page. |


## Properties


| Name | Summary |
|---|---|
| [routing](routing.html) | [jvm]<br>val [routing](routing.html): Routing.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The routing used for the http requests for a html page. |

