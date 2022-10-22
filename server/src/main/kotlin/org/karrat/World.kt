package org.karrat

import kotlinx.serialization.Serializable
import org.karrat.entity.Player
import org.karrat.serialization.serializer.PrimitiveWorldSerializer
import org.karrat.struct.BlockPos
import org.karrat.struct.Identifier
import org.karrat.struct.Vec2i
import org.karrat.struct.id
import org.karrat.world.WorldGenerator

@Serializable(with = PrimitiveWorldSerializer::class)
public class World(internal val world: org.bukkit.World) {

    public val identifier: Identifier = id("minecraft", world.name)
    public val seed: Long = world.seed
    public val generator: WorldGenerator = world.generator!!
    public val height: Int = world.maxHeight

    public val players: List<Player> = world.players.map { Player(it) }

    public companion object {
        public operator fun invoke(identifier: Identifier): World {
            return Server.worlds.firstOrNull { it.identifier == identifier }
                ?: error("Unable to find world.")
        }
    }

    /**
     * Gets the [Block] at position [pos].
     */
    public fun blockAt(pos: BlockPos): Block =
        get(pos.x, pos.y, pos.z)

    /**
     * Gets the [Block] at the given [x], [y], and [z] coordinates.
     */
    public operator fun get(x: Int, y: Int, z: Int): Block =
        get(x / 16, z / 16)[x % 16, y, z % 16]

    /**
     * Sets the [Block] at position [pos].
     */
    public fun setBlock(pos: BlockPos, block: Block): Unit =
        set(pos.x, pos.y, pos.z, block)

    /**
     * Sets the [Block] at the given [x], [y], and [z] coordinates.
     */
    public operator fun set(x: Int, y: Int, z: Int, block: Block): Unit =
        chunkAt(Vec2i(x / 16, z / 16)).set(x % 16, y, z % 16, block)

    /**
     * Gets the [Chunk] at the position [pos].
     */
    public fun chunkAt(pos: Vec2i): Chunk {
        if (chunks[pos] == null) { chunks[pos] = generator.generateChunk(this, pos) }
        return chunks[pos]!!
    }

    /**
     * Gets the [Chunk] at the given [x] and [z] coordinates.
     */
    public operator fun get(x: Int, z: Int): Chunk = chunkAt(Vec2i(x, z))

}