package org.karrat.entity

public open class Entity(
    internal val entity: org.bukkit.entity.Entity
) {

    public val id: Int = entity.entityId
    public val isAlive: Boolean get() = !entity.isDead

    public var gravity: Boolean
        get() = entity.hasGravity()
        set(value) {
            entity.setGravity(value)
        }
    public var invulnerable: Boolean
        get() = entity.isInvulnerable
        set(value) {
            entity.isInvulnerable = value
        }

    public fun kill(): Unit = remove()
    public fun remove() { entity.remove() }

}