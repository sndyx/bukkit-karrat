package org.karrat.bukkit

import org.bukkit.plugin.java.JavaPlugin
import org.karrat.Server

internal class KarratPlugin : JavaPlugin() {

    companion object {
        lateinit var instance: KarratPlugin
    }

    override fun onEnable() {
        instance = this
        Server.start()
    }

}