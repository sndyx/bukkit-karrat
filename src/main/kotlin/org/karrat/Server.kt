package org.karrat

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import org.bukkit.Bukkit
import org.karrat.entity.Player
import org.karrat.server.Benchmarks
import kotlin.coroutines.CoroutineContext

public object Server : CoroutineScope {

    @OptIn(DelicateCoroutinesApi::class)
    override val coroutineContext: CoroutineContext =
        newFixedThreadPoolContext(8, "worker-thread")

    public val worlds: List<World> get() = Bukkit.getWorlds().map { World(it) }
    public val players: List<Player> get() = worlds.flatMap { it.players }

    public fun start() {
        Benchmarks.start()
    }

    public fun stop() {
        Bukkit.shutdown()
    }

}