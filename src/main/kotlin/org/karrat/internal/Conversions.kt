/*
 * Copyright © Karrat - 2022.
 */

package org.karrat.internal

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.*
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import org.karrat.World
import org.karrat.entity.Player
import org.karrat.struct.*

internal fun org.bukkit.World.karrat()= World(this)
internal fun World.bukkit() = world

internal fun org.bukkit.Location.karrat() = Location(world!!.karrat(), x, y, z)
internal fun Location.bukkit() = org.bukkit.Location(world.bukkit(), x, y, z)

internal fun org.bukkit.entity.Player.karrat() = Player(this)
internal fun Player.bukkit() = player

private val clickActions = mapOf(
    ClickAction.RunCommand to ClickEvent.Action.RUN_COMMAND,
    ClickAction.ChangePage to ClickEvent.Action.CHANGE_PAGE,
    ClickAction.CopyToClipboard to ClickEvent.Action.COPY_TO_CLIPBOARD,
    ClickAction.OpenUrl to ClickEvent.Action.OPEN_URL,
    ClickAction.SuggestCommand to ClickEvent.Action.SUGGEST_COMMAND
)
private val hoverActions = mapOf(
    HoverAction.ShowEntity to HoverEvent.Action.SHOW_ENTITY,
    HoverAction.ShowItem to HoverEvent.Action.SHOW_ITEM,
    HoverAction.ShowText to HoverEvent.Action.SHOW_TEXT
)
private fun StyledText.bungee(): BaseComponent {
    return ComponentBuilder(content).also {
        if (bold != null) it.bold(bold)
        if (italic != null) it.italic(italic)
        if (underlined != null) it.underlined(underlined)
        if (strikethrough != null) it.strikethrough(strikethrough)
        if (obfuscated != null) it.obfuscated(obfuscated)
        if (color != null) { it.color(ChatColor.of("#$color")) }
        if (insertion != null) it.insertion(insertion)
        if (clickEvent != null) it.event(ClickEvent(clickActions[clickEvent.action], clickEvent.value))
        if (hoverEvent != null) it.event(HoverEvent(hoverActions[hoverEvent.action], ))
    }.create().single()
}
internal fun Message.bungee(): Array<BaseComponent> {
    return if (this is StyledMessage) { segments.map { it.bungee() }.toTypedArray() }
    else arrayOf(TextComponent(this.toString()))
}