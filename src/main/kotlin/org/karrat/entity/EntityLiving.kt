package org.karrat.entity

import org.bukkit.attribute.Attribute


public open class EntityLiving(
    internal val entityLiving: org.bukkit.entity.LivingEntity
) {

    public var health: Double
        get() = entityLiving.health
        set(value) { entityLiving.health = value }
    public var maxHealth: Double
        get() = entityLiving.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value ?: 0.0
        set(value) { entityLiving.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = value }

    public fun damage(amount: Double) {
        require(amount >= 0) { "Damage must not be negative." }
        health -= amount
    }

}