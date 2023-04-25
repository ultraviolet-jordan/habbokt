---
title: PacketAssembler
---
//[api](../../../index.html)/[com.habbokt.api.packet](../index.html)/[PacketAssembler](index.html)



# PacketAssembler



[jvm]\
abstract class [PacketAssembler](index.html)&lt;out [P](index.html) : [Packet](../-packet/index.html)&gt;(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val body: [ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [PacketAssembler](-packet-assembler.html) | [jvm]<br>constructor(id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), body: [ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [body](body.html) | [jvm]<br>val [body](body.html): [ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [id](id.html) | [jvm]<br>val [id](id.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

