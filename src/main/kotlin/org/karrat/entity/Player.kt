package org.karrat.entity

import net.md_5.bungee.api.ChatMessageType
import org.karrat.internal.bukkit
import org.karrat.internal.bungee
import org.karrat.internal.karrat
import org.karrat.struct.Location
import org.karrat.struct.Message

public class Player(
    internal val player: org.bukkit.entity.Player
) : EntityLiving(player) {

    public var compassTarget: Location
        get() = player.compassTarget.karrat()
        set(value) { player.compassTarget = value.bukkit() }

    public fun sendMessage(message: Message) {
        player.spigot().sendMessage(*message.bungee())
    }

    public fun actionBar(message: Message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, *message.bungee())
    }

}