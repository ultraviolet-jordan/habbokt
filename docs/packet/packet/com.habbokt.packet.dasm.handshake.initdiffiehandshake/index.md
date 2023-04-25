---
title: com.habbokt.packet.dasm.handshake.initdiffiehandshake
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.handshake.initdiffiehandshake](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [InitDiffieHandshakePacketDisassembler](-init-diffie-handshake-packet-disassembler/index.html) | [jvm]<br>class [InitDiffieHandshakePacketDisassembler](-init-diffie-handshake-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[InitDiffieHandshakeRequestPacket](-init-diffie-handshake-request-packet/index.html)&gt; |
| [InitDiffieHandshakeRequestPacket](-init-diffie-handshake-request-packet/index.html) | [jvm]<br>data class [InitDiffieHandshakeRequestPacket](-init-diffie-handshake-request-packet/index.html)(val value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [InitDiffieHandshakeRequestPacketHandler](-init-diffie-handshake-request-packet-handler/index.html) | [jvm]<br>class [InitDiffieHandshakeRequestPacketHandler](-init-diffie-handshake-request-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[InitDiffieHandshakeRequestProxyPacket](-init-diffie-handshake-request-proxy-packet/index.html)&gt; |
| [InitDiffieHandshakeRequestProxyPacket](-init-diffie-handshake-request-proxy-packet/index.html) | [jvm]<br>data class [InitDiffieHandshakeRequestProxyPacket](-init-diffie-handshake-request-proxy-packet/index.html)(val securityCastToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val serverToClient: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [InitDiffieHandshakeRequestProxyPacketHandler](-init-diffie-handshake-request-proxy-packet-handler/index.html) | [jvm]<br>class [InitDiffieHandshakeRequestProxyPacketHandler](-init-diffie-handshake-request-proxy-packet-handler/index.html) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[InitDiffieHandshakeRequestPacket](-init-diffie-handshake-request-packet/index.html), [InitDiffieHandshakeRequestProxyPacket](-init-diffie-handshake-request-proxy-packet/index.html)&gt; |

