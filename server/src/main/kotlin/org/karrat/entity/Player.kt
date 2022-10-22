package org.karrat.entity

import net.md_5.bungee.api.ChatMessageType
import org.karrat.internal.bukkit
import org.karrat.internal.bungee
import org.karrat.internal.karrat
import org.karrat.internal.property
import org.karrat.struct.Location
import org.karrat.struct.Message
import org.karrat.struct.formatted

public class Player(
    internal val player: org.bukkit.entity.Player
) : EntityLiving(player) {

    public val locale: String by property(player::getLocale)
    public val ping: Int by property(player::getPing)

    public var compassTarget: Location
        get() = player.compassTarget.karrat()
        set(value) { player.compassTarget = value.bukkit() }
    public var spectatorTarget: Entity?
        get() = player.spectatorTarget?.karrat()
        set(value) { player.spectatorTarget = value?.bukkit() }

    public var exp: Float by property(player::getExp, player::setExp)

    public var isFlying: Boolean by property(player::isFlying, player::setFlying)
    public var isSneaking: Boolean by property(player::isSneaking, player::setSneaking)
    public var isSprinting: Boolean by property(player::isSprinting, player::setSprinting)

    public var flySpeed: Float by property(player::getFlySpeed, player::setFlySpeed)
    public var walkSpeed: Float by property(player::getWalkSpeed, player::setWalkSpeed)
    public fun sendMessage(message: Message) {
        player.spigot().sendMessage(*message.bungee())
    }

    public fun actionBar(message: Message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, *message.bungee())
    }

    public fun title(
        title: Message? = null,
        subtitle: Message? = null,
        fadeIn: Int = 20,
        stay: Int = 60,
        fadeOut: Int = 20
    ) {
        player.sendTitle(
            title?.formatted(), subtitle?.formatted(),
            fadeIn, stay, fadeOut
        )
    }

    public fun kick(message: Message? = null) {
        player.kickPlayer(message?.formatted())
    }

}