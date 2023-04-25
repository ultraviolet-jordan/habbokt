---
title: com.habbokt.page
---
//[page](../../index.html)/[com.habbokt.page](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [Ajax](-ajax/index.html) | [jvm]<br>class [Ajax](-ajax/index.html)(val json: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ResponseType](-response-type/index.html) |
| [Authentications](-authentications/index.html) | [jvm]<br>object [Authentications](-authentications/index.html) |
| [BlankPageService](-blank-page-service/index.html) | [jvm]<br>abstract class [BlankPageService](-blank-page-service/index.html)&lt;[R](-blank-page-service/index.html) : [PageRequest](-page-request/index.html), [G](-blank-page-service/index.html) : [ResponseType](-response-type/index.html), [P](-blank-page-service/index.html) : [ResponseType](-response-type/index.html)&gt;(get: suspend [R](-blank-page-service/index.html).() -&gt; [G](-blank-page-service/index.html)? = null, post: suspend [R](-blank-page-service/index.html).() -&gt; [P](-blank-page-service/index.html)? = null) : [PageService](-page-service/index.html)&lt;[R](-blank-page-service/index.html), [G](-blank-page-service/index.html), [P](-blank-page-service/index.html)&gt; |
| [Html](-html/index.html) | [jvm]<br>class [Html](-html/index.html)(val content: PebbleContent) : [ResponseType](-response-type/index.html) |
| [HttpClientProvider](-http-client-provider/index.html) | [jvm]<br>class [HttpClientProvider](-http-client-provider/index.html) : Provider&lt;HttpClient&gt; |
| [None](-none/index.html) | [jvm]<br>object [None](-none/index.html) : [ResponseType](-response-type/index.html) |
| [Page](-page/index.html) | [jvm]<br>abstract class [Page](-page/index.html)&lt;[R](-page/index.html) : [PageRequest](-page-request/index.html)&gt;(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val template: suspend [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;.([R](-page/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [PageModule](-page-module/index.html) | [jvm]<br>object [PageModule](-page-module/index.html) : KotlinModule |
| [PageRequest](-page-request/index.html) | [jvm]<br>interface [PageRequest](-page-request/index.html) |
| [PageRouting](-page-routing/index.html) | [jvm]<br>abstract class [PageRouting](-page-routing/index.html)(val routing: Routing.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [PageService](-page-service/index.html) | [jvm]<br>abstract class [PageService](-page-service/index.html)&lt;[R](-page-service/index.html) : [PageRequest](-page-request/index.html), [G](-page-service/index.html) : [ResponseType](-response-type/index.html), [P](-page-service/index.html) : [ResponseType](-response-type/index.html)&gt;(get: suspend [R](-page-service/index.html).() -&gt; [G](-page-service/index.html)? = null, post: suspend [R](-page-service/index.html).() -&gt; [P](-page-service/index.html)? = null) |
| [Png](-png/index.html) | [jvm]<br>class [Png](-png/index.html)(val bytes: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)) : [ResponseType](-response-type/index.html) |
| [Redirect](-redirect/index.html) | [jvm]<br>class [Redirect](-redirect/index.html)(val path: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ResponseType](-response-type/index.html) |
| [ResponseType](-response-type/index.html) | [jvm]<br>interface [ResponseType](-response-type/index.html) |


## Functions


| Name | Summary |
|---|---|
| [ajax](ajax.html) | [jvm]<br>fun [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;.[ajax](ajax.html)(): [Ajax](-ajax/index.html) |
| [html](html.html) | [jvm]<br>inline suspend fun &lt;[R](html.html) : [PageRequest](-page-request/index.html)&gt; [Page](-page/index.html)&lt;[R](html.html)&gt;.[html](html.html)(request: [R](html.html)): [Html](-html/index.html) |
| [png](png.html) | [jvm]<br>fun [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html).[png](png.html)(): [Png](-png/index.html) |
| [redirect](redirect.html) | [jvm]<br>fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[redirect](redirect.html)(): [Redirect](-redirect/index.html) |

