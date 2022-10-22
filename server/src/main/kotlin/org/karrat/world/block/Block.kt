package org.karrat.world.block

import org.bukkit.Bukkit
import org.karrat.internal.bukkit
import org.karrat.internal.karrat
import org.karrat.internal.property
import org.karrat.play.Material

public open class Block(
    internal val data: org.bukkit.block.data.BlockData
) {

    public val type: Material = data.material.karrat()

    public constructor(material: Material): this(Bukkit.createBlockData(material.bukkit()))

    public companion object {

        public fun from(data: String): Block {
            return Block(Bukkit.createBlockData(data))
        }

    }

    public val x: String = """
        
    """.trimIndent()

    public class Air: Block(Material.Air)

    public class Tnt(
        internal val tnt: org.bukkit.block.data.type.TNT
    ) : Block(tnt) {

        public var isUnstable: Boolean by property(tnt::isUnstable, tnt::setUnstable)

        public constructor(
            isUnstable: Boolean
        ) : this (
            Bukkit.createBlockData(org.bukkit.Material.TNT) as org.bukkit.block.data.type.TNT
        ) {
            tnt.isUnstable = isUnstable
        }

    }

}