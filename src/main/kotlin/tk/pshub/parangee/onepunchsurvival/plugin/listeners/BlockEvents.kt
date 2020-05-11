package tk.pshub.parangee.onepunchsurvival.plugin.listeners

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDamageEvent
import tk.pshub.parangee.onepunchsurvival.plugin.OnePunchSurvival

class BlockEvents:Listener {
    private val pl = Bukkit.getPluginManager().getPlugin("OnePunchSurvival") as OnePunchSurvival
    @EventHandler
    fun onBlockDamage(e:BlockDamageEvent) {
        if(pl.players.contains(e.player)) {
            e.block.breakNaturally(e.player.inventory.itemInMainHand)
        }
    }
}