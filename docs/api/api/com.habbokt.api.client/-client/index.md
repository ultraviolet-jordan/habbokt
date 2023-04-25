---
title: Client
---
//[api](../../../index.html)/[com.habbokt.api.client](../index.html)/[Client](index.html)



# Client



[jvm]\
interface [Client](index.html)

#### Author



Jordan Abraham



## Functions


| Name | Summary |
|---|---|
| [accept](accept.html) | [jvm]<br>abstract suspend fun [accept](accept.html)() |
| [authenticate](authenticate.html) | [jvm]<br>abstract fun [authenticate](authenticate.html)(userId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [awaitPacket](await-packet.html) | [jvm]<br>abstract suspend fun [awaitPacket](await-packet.html)(): [Packet](../../com.habbokt.api.packet/-packet/index.html)? |
| [close](close.html) | [jvm]<br>abstract fun [close](close.html)() |
| [connected](connected.html) | [jvm]<br>abstract fun [connected](connected.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [player](player.html) | [jvm]<br>abstract fun [player](player.html)(): [Player](../../com.habbokt.api.entity.player/-player/index.html)? |
| [processReadPool](process-read-pool.html) | [jvm]<br>abstract fun [processReadPool](process-read-pool.html)() |
| [processWritePool](process-write-pool.html) | [jvm]<br>abstract fun [processWritePool](process-write-pool.html)() |
| [socketAddress](socket-address.html) | [jvm]<br>abstract fun [socketAddress](socket-address.html)(): SocketAddress |
| [writePacket](write-packet.html) | [jvm]<br>abstract fun [writePacket](write-packet.html)(packet: [Packet](../../com.habbokt.api.packet/-packet/index.html)) |

