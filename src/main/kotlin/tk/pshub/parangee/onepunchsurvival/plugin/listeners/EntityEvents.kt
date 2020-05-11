package tk.pshub.parangee.onepunchsurvival.plugin.listeners

import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import tk.pshub.parangee.onepunchsurvival.plugin.OnePunchSurvival

class EntityEvents:Listener {
    private val pl = Bukkit.getPluginManager().getPlugin("OnePunchSurvival") as OnePunchSurvival
    @EventHandler
    fun onDamage(e:EntityDamageEvent) {
        if (e.entity is LivingEntity) {
            if(e.entity is Player) {
                var player = e.entity as Player
                if (pl.players.contains(player)) {
                    var entity = e.entity as LivingEntity
                    entity.health = 0.0
                }
            } else {
                var entity = e.entity as LivingEntity
                entity.health = 0.0
            }
        }
    }
}