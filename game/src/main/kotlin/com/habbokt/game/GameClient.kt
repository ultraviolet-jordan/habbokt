package com.habbokt.game

import com.habbokt.api.common.base64
import com.habbokt.api.client.Client
import com.habbokt.api.client.DisconnectReason
import com.habbokt.api.client.handshake.LoginInformation
import com.habbokt.api.packet.AuthenticationOKPacket
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.UserRightsPacket
import com.habbokt.api.packet.assembler.PacketAssemblerDeclaration
import com.habbokt.api.packet.disassembler.PacketDisassemblerDeclaration
import com.habbokt.api.packet.handler.PacketHandler
import com.habbokt.api.packet.handler.PacketHandlerDeclaration
import com.habbokt.api.player.Player
import com.habbokt.game.player.GamePlayer
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import java.nio.ByteBuffer
import kotlin.reflect.KClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * @author Jordan Abraham
 */
class GameClient(
    private val readChannel: ByteReadChannel,
    private val writeChannel: ByteWriteChannel,
    private val assemblers: Map<KClass<*>, PacketAssemblerDeclaration<Packet>>,
    private val disassemblers: Map<Int, PacketDisassemblerDeclaration>,
    private val handlers: Map<KClass<*>, PacketHandlerDeclaration<Packet>>
) : Client {
    private val writePool = ByteBuffer.allocateDirect(256)

    private lateinit var gamePlayer: Player

    override fun readChannel(): ByteReadChannel = readChannel
    override fun writeChannel(): ByteWriteChannel = writeChannel
    override fun bufferPool(): ByteBuffer = writePool

    override suspend fun awaitPacket(): Packet? {
        if (readChannel.isClosedForRead) {
            return null
        }
        if (readChannel.availableForRead < 5) {
            readChannel.awaitContent()
        }
        val size = ByteArray(3) { readChannel.readByte() }.base64()
        if (readChannel.availableForRead < size || size < 0) {
            if (size > 0) {
                readChannel.discard(size.toLong())
            }
            return null
        }
        val buffer = ByteBuffer.wrap(readChannel.readPacket(size).readBytes())
        val id = String(ByteArray(2) { buffer.get() }).toByteArray().base64()
        println("DEBUG Incoming Packet: ID=$id, SIZE=$size, REMAINING=${buffer.remaining()}")
        return disassemblers[id]?.packetDisassembler?.packet?.invoke(buffer)
    }

    override suspend fun handlePacket(packet: Packet) {
        val handler = PacketHandler(this, packet)
        handlers[handler.packet::class]?.handler?.invoke(handler)
    }

    override fun writePacket(packet: Packet) {
        // TODO Use the write pool properly. For now I am just writing back to client immediately.
        // TODO It should be pooling the data from multiple packets if possible then writing to client.
        val declaration = assemblers[packet::class] ?: return
        val packetId = declaration.assembler.id
        println("DEBUG Outgoing Packet: ID = $packetId, ASSEMBLER=${declaration.assembler}")
        writePool.put(packetId.base64(2)) // Write packet id.
        declaration.assembler.packet.invoke(packet, writePool) // Invoke packet body.
        writePool.put(1) // End packet.

        if (writeChannel.isClosedForWrite) return
        writeChannel.apply {
            runBlocking(Dispatchers.IO) {
                writeFully(writePool.flip())
            }
        }.flush()
        writePool.clear()
    }

    override fun getPlayer(): Player? {
        if (!::gamePlayer.isInitialized) return null
        return gamePlayer
    }

    override fun validateLogin(information: LoginInformation): Player? = GamePlayer(information.id, information.username)
        .validateLogin(information)
        ?.also { this.gamePlayer = it }

    override fun logout() {
        TODO("Not yet implemented")
    }
}