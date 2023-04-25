---
title: ServerConfiguration
---
//[game](../../../index.html)/[com.habbokt.game](../index.html)/[ServerConfiguration](index.html)



# ServerConfiguration



[jvm]\
data class [ServerConfiguration](index.html)@Injectconstructor(val assemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketAssembler](../../../../api/api/com.habbokt.api.packet/-packet-assembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, val disassemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [PacketDisassembler](../../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, val handlers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketHandler](../../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;, val proxies: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html), [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;)

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [ServerConfiguration](-server-configuration.html) | [jvm]<br>@Inject<br>constructor(assemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketAssembler](../../../../api/api/com.habbokt.api.packet/-packet-assembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, disassemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [PacketDisassembler](../../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, handlers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketHandler](../../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;, proxies: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html), [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;) |


## Properties


| Name | Summary |
|---|---|
| [assemblers](assemblers.html) | [jvm]<br>val [assemblers](assemblers.html): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketAssembler](../../../../api/api/com.habbokt.api.packet/-packet-assembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt; |
| [disassemblers](disassemblers.html) | [jvm]<br>val [disassemblers](disassemblers.html): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [PacketDisassembler](../../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt; |
| [handlers](handlers.html) | [jvm]<br>val [handlers](handlers.html): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketHandler](../../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt; |
| [proxies](proxies.html) | [jvm]<br>val [proxies](proxies.html): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html), [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt; |

