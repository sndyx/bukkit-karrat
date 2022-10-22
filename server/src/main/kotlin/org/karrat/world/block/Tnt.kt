package org.karrat.world.block

import org.bukkit.Bukkit
import org.bukkit.Material
import org.karrat.internal.property

public class Tnt(
    internal val tnt: org.bukkit.block.data.type.TNT
) {

    public var isUnstable: Boolean by property(tnt::isUnstable, tnt::setUnstable)

    public constructor(
        isUnstable: Boolean
    ) : this (
        Bukkit.createBlockData(Material.TNT) as org.bukkit.block.data.type.TNT
    ) {
        tnt.isUnstable = isUnstable
    }

}