package tk.pshub.parangee.onepunchsurvival.plugin.listeners

import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class EntityEvents:Listener {
    @EventHandler
    fun onDamage(e:EntityDamageEvent) {
        if (e.entity is LivingEntity) {
            var entity = e.entity as LivingEntity
            entity.health = 0.0
        }
    }
}