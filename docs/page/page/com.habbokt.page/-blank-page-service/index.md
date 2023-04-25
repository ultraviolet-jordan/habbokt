---
title: BlankPageService
---
//[page](../../../index.html)/[com.habbokt.page](../index.html)/[BlankPageService](index.html)



# BlankPageService

abstract class [BlankPageService](index.html)&lt;[R](index.html) : [PageRequest](../-page-request/index.html), [G](index.html) : [ResponseType](../-response-type/index.html), [P](index.html) : [ResponseType](../-response-type/index.html)&gt;(get: suspend [R](index.html).() -&gt; [G](index.html)? = null, post: suspend [R](index.html).() -&gt; [P](index.html)? = null) : [PageService](../-page-service/index.html)&lt;[R](index.html), [G](index.html), [P](index.html)&gt; 

#### Author



Jordan Abraham



#### Inheritors


| |
|---|
| [CaptchaService](../../com.habbokt.page.captcha/-captcha-service/index.html) |
| [NameCheckAjaxService](../../com.habbokt.page.habblet.ajax.namecheck/-name-check-ajax-service/index.html) |
| [AvatarImageService](../../com.habbokt.page.habboimaging.avatarimage/-avatar-image-service/index.html) |


## Constructors


| | |
|---|---|
| [BlankPageService](-blank-page-service.html) | [jvm]<br>constructor(get: suspend [R](index.html).() -&gt; [G](index.html)? = null, post: suspend [R](index.html).() -&gt; [P](index.html)? = null) |


## Functions


| Name | Summary |
|---|---|
| [getRequest](../-page-service/get-request.html) | [jvm]<br>suspend fun [getRequest](../-page-service/get-request.html)(request: [R](index.html)): [G](index.html)<br>Handles the http GET request to this service if applicable. |
| [postRequest](../-page-service/post-request.html) | [jvm]<br>suspend fun [postRequest](../-page-service/post-request.html)(request: [R](index.html)): [P](index.html)<br>Handles the http POST request to this service if applicable. |

