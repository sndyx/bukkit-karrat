/*
 * Copyright © Karrat - 2022.
 */

package org.karrat.server

import org.bukkit.Bukkit
import org.karrat.bukkit.KarratPlugin

internal object Benchmarks {

    var tps = 20.0f

    fun start() {
        var then = System.currentTimeMillis()
        Bukkit.getScheduler().scheduleSyncRepeatingTask(KarratPlugin.instance, {
            val now = System.currentTimeMillis()
            tps = 1000.0f / maxOf(50, (now - then))
            then = now
        }, 0, 1)
    }

}
