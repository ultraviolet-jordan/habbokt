---
title: com.habbokt.api.packet
---
//[api](../../index.html)/[com.habbokt.api.packet](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [Packet](-packet/index.html) | [jvm]<br>interface [Packet](-packet/index.html) |
| [PacketAssembler](-packet-assembler/index.html) | [jvm]<br>abstract class [PacketAssembler](-packet-assembler/index.html)&lt;out [P](-packet-assembler/index.html) : [Packet](-packet/index.html)&gt;(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val body: [ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](-packet-assembler/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [PacketDisassembler](-packet-disassembler/index.html) | [jvm]<br>abstract class [PacketDisassembler](-packet-disassembler/index.html)&lt;out [P](-packet-disassembler/index.html) : [Packet](-packet/index.html)&gt;(val body: suspend ByteReadChannel.([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -&gt; @[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](-packet-disassembler/index.html)) |
| [PacketHandler](-packet-handler/index.html) | [jvm]<br>abstract class [PacketHandler](-packet-handler/index.html)&lt;out [P](-packet-handler/index.html) : [ProxyPacket](-proxy-packet/index.html)&gt;(val handler: [Client](../com.habbokt.api.client/-client/index.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](-packet-handler/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [ProxyPacket](-proxy-packet/index.html) | [jvm]<br>interface [ProxyPacket](-proxy-packet/index.html) |
| [ProxyPacketHandler](-proxy-packet-handler/index.html) | [jvm]<br>abstract class [ProxyPacketHandler](-proxy-packet-handler/index.html)&lt;out [P](-proxy-packet-handler/index.html) : [Packet](-packet/index.html), out [T](-proxy-packet-handler/index.html) : [ProxyPacket](-proxy-packet/index.html)&gt;(val handler: suspend [Client](../com.habbokt.api.client/-client/index.html).(@[UnsafeVariance](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unsafe-variance/index.html)[P](-proxy-packet-handler/index.html)) -&gt; [T](-proxy-packet-handler/index.html)?) |

