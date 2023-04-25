---
title: PacketDisassembler
---
//[api](../../../index.html)/[com.habbokt.api.packet](../index.html)/[PacketDisassembler](index.html)



# PacketDisassembler



[jvm]\
abstract class [PacketDisassembler](index.html)&lt;out [P](index.html) : [Packet](../-packet/index.html)&gt;(val body: suspend ByteReadChannel.([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; @[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html))

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [PacketDisassembler](-packet-disassembler.html) | [jvm]<br>constructor(body: suspend ByteReadChannel.([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; @[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) |


## Properties


| Name | Summary |
|---|---|
| [body](body.html) | [jvm]<br>val [body](body.html): suspend ByteReadChannel.([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; @[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html) |

