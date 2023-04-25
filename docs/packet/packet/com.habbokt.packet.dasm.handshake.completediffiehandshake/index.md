---
title: com.habbokt.packet.dasm.handshake.completediffiehandshake
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.handshake.completediffiehandshake](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [CompleteDiffieHandshakeRequestPacket](-complete-diffie-handshake-request-packet/index.html) | [jvm]<br>data class [CompleteDiffieHandshakeRequestPacket](-complete-diffie-handshake-request-packet/index.html)(val publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [CompleteDiffieHandshakeRequestPacketDisassembler](-complete-diffie-handshake-request-packet-disassembler/index.html) | [jvm]<br>class [CompleteDiffieHandshakeRequestPacketDisassembler](-complete-diffie-handshake-request-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[CompleteDiffieHandshakeRequestPacket](-complete-diffie-handshake-request-packet/index.html)&gt; |
| [CompleteDiffieHandshakeRequestPacketHandler](-complete-diffie-handshake-request-packet-handler/index.html) | [jvm]<br>class [CompleteDiffieHandshakeRequestPacketHandler](-complete-diffie-handshake-request-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[CompleteDiffieHandshakeRequestProxyPacket](-complete-diffie-handshake-request-proxy-packet/index.html)&gt; |
| [CompleteDiffieHandshakeRequestProxyPacket](-complete-diffie-handshake-request-proxy-packet/index.html) | [jvm]<br>data class [CompleteDiffieHandshakeRequestProxyPacket](-complete-diffie-handshake-request-proxy-packet/index.html)(val secretKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [CompleteDiffieHandshakeRequestProxyPacketHandler](-complete-diffie-handshake-request-proxy-packet-handler/index.html) | [jvm]<br>class [CompleteDiffieHandshakeRequestProxyPacketHandler](-complete-diffie-handshake-request-proxy-packet-handler/index.html) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[CompleteDiffieHandshakeRequestPacket](-complete-diffie-handshake-request-packet/index.html), [CompleteDiffieHandshakeRequestProxyPacket](-complete-diffie-handshake-request-proxy-packet/index.html)&gt; |

