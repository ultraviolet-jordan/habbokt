---
title: ProxyPacketHandler
---
//[api](../../../index.html)/[com.habbokt.api.packet](../index.html)/[ProxyPacketHandler](index.html)



# ProxyPacketHandler



[jvm]\
abstract class [ProxyPacketHandler](index.html)&lt;out [P](index.html) : [Packet](../-packet/index.html), out [T](index.html) : [ProxyPacket](../-proxy-packet/index.html)&gt;(val handler: suspend [Client](../../com.habbokt.api.client/-client/index.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [T](index.html)?)

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [ProxyPacketHandler](-proxy-packet-handler.html) | [jvm]<br>constructor(handler: suspend [Client](../../com.habbokt.api.client/-client/index.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [T](index.html)?) |


## Properties


| Name | Summary |
|---|---|
| [handler](handler.html) | [jvm]<br>val [handler](handler.html): suspend [Client](../../com.habbokt.api.client/-client/index.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [T](index.html)? |

