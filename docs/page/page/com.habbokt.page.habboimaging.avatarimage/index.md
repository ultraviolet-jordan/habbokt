---
title: com.habbokt.page.habboimaging.avatarimage
---
//[page](../../index.html)/[com.habbokt.page.habboimaging.avatarimage](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [AvatarImageRequest](-avatar-image-request/index.html) | [jvm]<br>data class [AvatarImageRequest](-avatar-image-request/index.html)(val figure: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val size: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val direction: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val headDirection: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val crr: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val gesture: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val frame: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PageRequest](../com.habbokt.page/-page-request/index.html) |
| [AvatarImageRouting](-avatar-image-routing/index.html) | [jvm]<br>class [AvatarImageRouting](-avatar-image-routing/index.html)@Injectconstructor(service: [AvatarImageService](-avatar-image-service/index.html)) : [PageRouting](../com.habbokt.page/-page-routing/index.html) |
| [AvatarImageService](-avatar-image-service/index.html) | [jvm]<br>class [AvatarImageService](-avatar-image-service/index.html)@Injectconstructor(httpClient: HttpClient) : [BlankPageService](../com.habbokt.page/-blank-page-service/index.html)&lt;[AvatarImageRequest](-avatar-image-request/index.html), [Png](../com.habbokt.page/-png/index.html), [None](../com.habbokt.page/-none/index.html)&gt; |

