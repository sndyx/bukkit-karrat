/*
 * Copyright © Karrat - 2022.
 */
@file:Suppress("Unused")

package org.karrat.command

import org.bukkit.Bukkit
import org.karrat.internal.bukkit
import org.karrat.plugin.Plugin
import org.karrat.plugin.minecraft

private fun Command.bukkitRunnable(): Command = vararg<String>().also {
    executor.playerExecutor = {
        Bukkit.dispatchCommand(sender.bukkit(), args.joinToString(" "))
    }
    executor.consoleExecutor = {
        Bukkit.dispatchCommand(Bukkit.getServer().consoleSender, args.joinToString(" "))
    }
}

internal fun Command.CommandRegistry.registerDefaults() {
    with(Command.Default) {
        listOf(
            advancement,
            ban,
            banIp,
            banList,
            clear,
            debug,
            defaultGameMode,
            deOp,
            difficulty,
            effect,
            enchant,
            gameMode,
            gameRule,
            give,
            help,
            kick,
            kill,
            list,
            me,
            op,
            pardon,
            pardonIp,
            playSound,
            saveAll,
            saveOff,
            saveOn,
            say,
            scoreboard,
            seed,
            setBlock,
            fill,
            setIdleTimeout,
            setWorldSpawn,
            spawnPoint,
            spreadPlayers,
            stop,
            summon,
            tell,
            tellRaw,
            testFor,
            testForBlock,
            time,
            toggleDownfall,
            tp,
            weather,
            whitelist,
            xp
        ).forEach {
            with(Plugin.minecraft) {
                register(it)
            }
        }
    }
}

public val Command.Default.advancement: Command
    get() = command("advancement").bukkitRunnable()
public val Command.Default.ban: Command
    get() = command("ban").bukkitRunnable()
public val Command.Default.banIp: Command
    get() = command("ban-ip").bukkitRunnable()
public val Command.Default.banList: Command
    get() = command("banlist").bukkitRunnable()
public val Command.Default.clear: Command
    get() = command("clear").bukkitRunnable()
public val Command.Default.debug: Command
    get() = command("debug").bukkitRunnable()
public val Command.Default.defaultGameMode: Command
    get() = command("defaultgamemode").bukkitRunnable()
public val Command.Default.deOp: Command
    get() = command("deop").bukkitRunnable()
public val Command.Default.difficulty: Command
    get() = command("difficulty").bukkitRunnable()
public val Command.Default.effect: Command
    get() = command("effect").bukkitRunnable()
public val Command.Default.enchant: Command
    get() = command("enchant").bukkitRunnable()
public val Command.Default.gameMode: Command
    get() = command("gamemode").bukkitRunnable()
public val Command.Default.gameRule: Command
    get() = command("gamerule").bukkitRunnable()
public val Command.Default.give: Command
    get() = command("give").bukkitRunnable()
public val Command.Default.help: Command
    get() = command("help").bukkitRunnable()
public val Command.Default.kick: Command
    get() = command("kick").bukkitRunnable()
public val Command.Default.kill: Command
    get() = command("kill").bukkitRunnable()
public val Command.Default.list: Command
    get() = command("list").bukkitRunnable()
public val Command.Default.me: Command
    get() = command("me").bukkitRunnable()
public val Command.Default.op: Command
    get() = command("op").bukkitRunnable()
public val Command.Default.pardon: Command
    get() = command("pardon").bukkitRunnable()
public val Command.Default.pardonIp: Command
    get() = command("pardon-ip").bukkitRunnable()
public val Command.Default.playSound: Command
    get() = command("playsound").bukkitRunnable()
public val Command.Default.saveAll: Command
    get() = command("save-all").bukkitRunnable()
public val Command.Default.saveOff: Command
    get() = command("save-off").bukkitRunnable()
public val Command.Default.saveOn: Command
    get() = command("save-on").bukkitRunnable()
public val Command.Default.say: Command
    get() = command("say").bukkitRunnable()
public val Command.Default.scoreboard: Command
    get() = command("scoreboard").bukkitRunnable()
public val Command.Default.seed: Command
    get() = command("seed").bukkitRunnable()
public val Command.Default.setBlock: Command
    get() = command("setblock").bukkitRunnable()
public val Command.Default.fill: Command
    get() = command("fill").bukkitRunnable()
public val Command.Default.setIdleTimeout: Command
    get() = command("setidletimeout").bukkitRunnable()
public val Command.Default.setWorldSpawn: Command
    get() = command("setworldspawn").bukkitRunnable()
public val Command.Default.spawnPoint: Command
    get() = command("spawnpoint").bukkitRunnable()
public val Command.Default.spreadPlayers: Command
    get() = command("spreadplayers").bukkitRunnable()
public val Command.Default.stop: Command
    get() = command("stop").bukkitRunnable()
public val Command.Default.summon: Command
    get() = command("summon").bukkitRunnable()
public val Command.Default.tell: Command
    get() = command("tell").bukkitRunnable()
public val Command.Default.tellRaw: Command
    get() = command("tellraw").bukkitRunnable()
public val Command.Default.testFor: Command
    get() = command("testfor").bukkitRunnable()
public val Command.Default.testForBlock: Command
    get() = command("testforblock").bukkitRunnable()
public val Command.Default.time: Command
    get() = command("time").bukkitRunnable()
public val Command.Default.toggleDownfall: Command
    get() = command("toggledownfall").bukkitRunnable()
public val Command.Default.tp: Command
    get() = command("tp").bukkitRunnable()
public val Command.Default.weather: Command
    get() = command("weather").bukkitRunnable()
public val Command.Default.whitelist: Command
    get() = command("whitelist").bukkitRunnable()
public val Command.Default.xp: Command
    get() = command("xp").bukkitRunnable()