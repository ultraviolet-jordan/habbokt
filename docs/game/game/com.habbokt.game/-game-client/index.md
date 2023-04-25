---
title: GameClient
---
//[game](../../../index.html)/[com.habbokt.game](../index.html)/[GameClient](index.html)



# GameClient



[jvm]\
class [GameClient](index.html)(logger: Logger, socket: Socket, connectionPool: [ConnectionPool](../-connection-pool/index.html), assemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketAssembler](../../../../api/api/com.habbokt.api.packet/-packet-assembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, disassemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [PacketDisassembler](../../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, handlers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketHandler](../../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;, proxies: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html), [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;) : [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [GameClient](-game-client.html) | [jvm]<br>constructor(logger: Logger, socket: Socket, connectionPool: [ConnectionPool](../-connection-pool/index.html), assemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketAssembler](../../../../api/api/com.habbokt.api.packet/-packet-assembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, disassemblers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [PacketDisassembler](../../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)&gt;&gt;, handlers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [PacketHandler](../../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;, proxies: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;, [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html), [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)&gt;&gt;) |


## Functions


| Name | Summary |
|---|---|
| [accept](accept.html) | [jvm]<br>open suspend override fun [accept](accept.html)() |
| [authenticate](authenticate.html) | [jvm]<br>open override fun [authenticate](authenticate.html)(userId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [awaitPacket](await-packet.html) | [jvm]<br>open suspend override fun [awaitPacket](await-packet.html)(): [Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)? |
| [close](close.html) | [jvm]<br>open override fun [close](close.html)() |
| [connected](connected.html) | [jvm]<br>open override fun [connected](connected.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [player](player.html) | [jvm]<br>open override fun [player](player.html)(): [Player](../../../../api/api/com.habbokt.api.entity.player/-player/index.html)? |
| [processReadPool](process-read-pool.html) | [jvm]<br>open override fun [processReadPool](process-read-pool.html)() |
| [processWritePool](process-write-pool.html) | [jvm]<br>open override fun [processWritePool](process-write-pool.html)() |
| [socketAddress](socket-address.html) | [jvm]<br>open override fun [socketAddress](socket-address.html)(): SocketAddress |
| [writePacket](write-packet.html) | [jvm]<br>open override fun [writePacket](write-packet.html)(packet: [Packet](../../../../api/api/com.habbokt.api.packet/-packet/index.html)) |

