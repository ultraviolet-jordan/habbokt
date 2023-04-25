---
title: com.habbokt.packet.dasm.handshake.inforetrieve
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.handshake.inforetrieve](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [InfoRetrievePacket](-info-retrieve-packet/index.html) | [jvm]<br>class [InfoRetrievePacket](-info-retrieve-packet/index.html) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [InfoRetrievePacketDisassembler](-info-retrieve-packet-disassembler/index.html) | [jvm]<br>class [InfoRetrievePacketDisassembler](-info-retrieve-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[InfoRetrievePacket](-info-retrieve-packet/index.html)&gt; |
| [InfoRetrievePacketHandler](-info-retrieve-packet-handler/index.html) | [jvm]<br>class [InfoRetrievePacketHandler](-info-retrieve-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[InfoRetrieveProxyPacket](-info-retrieve-proxy-packet/index.html)&gt; |
| [InfoRetrieveProxyPacket](-info-retrieve-proxy-packet/index.html) | [jvm]<br>data class [InfoRetrieveProxyPacket](-info-retrieve-proxy-packet/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val figure: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val sex: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val motto: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [InfoRetrieveProxyPacketHandler](-info-retrieve-proxy-packet-handler/index.html) | [jvm]<br>class [InfoRetrieveProxyPacketHandler](-info-retrieve-proxy-packet-handler/index.html)@Injectconstructor(playersService: PlayersService) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[InfoRetrievePacket](-info-retrieve-packet/index.html), [InfoRetrieveProxyPacket](-info-retrieve-proxy-packet/index.html)&gt; |

