package org.karrat

import kotlinx.serialization.Serializable
import org.karrat.entity.Player
import org.karrat.internal.BWorld
import org.karrat.serialization.serializer.PrimitiveWorldSerializer
import org.karrat.struct.Identifier
import org.karrat.struct.id
import org.karrat.world.WorldGenerator

@Serializable(with = PrimitiveWorldSerializer::class)
public class World(internal val world: BWorld) {

    public val identifier: Identifier = id("minecraft", bukkit.name)
    public val seed: Long = bukkit.seed
    public val generator: WorldGenerator = bukkit.generator!!
    public val height: Int = bukkit.maxHeight

    public val players: List<Player> = bukkit.players.map { Player(it) }

    public companion object {
        public operator fun invoke(identifier: Identifier): World {
            return Server.worlds.firstOrNull { it.identifier == identifier }
                ?: error("Unable to find world.")
        }
    }

}