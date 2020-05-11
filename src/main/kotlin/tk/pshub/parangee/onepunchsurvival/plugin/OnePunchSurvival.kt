package tk.pshub.parangee.onepunchsurvival.plugin

import com.github.noonmaru.tap.command.command
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import tk.pshub.parangee.onepunchsurvival.plugin.command.CommandAdd
import tk.pshub.parangee.onepunchsurvival.plugin.command.CommandList
import tk.pshub.parangee.onepunchsurvival.plugin.command.CommandRemove
import tk.pshub.parangee.onepunchsurvival.plugin.listeners.BlockEvents
import tk.pshub.parangee.onepunchsurvival.plugin.listeners.EntityEvents


class OnePunchSurvival:JavaPlugin() {
    val players = ArrayList<Player>()
    override fun onEnable() {
        Bukkit.broadcastMessage("원펀맨 야생 플러그인은 파랑이가 제작했습니다.")
        Bukkit.broadcastMessage("제작자 깃허브: https://github.com/parangee")
        Bukkit.broadcastMessage("제작자 웹사이트: https://pshub.tk")
        logger.info("원펀맨 야생 시스템 로딩됨")
        setupCommands()
        registerEvents()
    }
    private fun setupCommands() {
        command("onepunch") {
            help("help") {
                description = "설명을 확인합니다."
            }
            component("add") {
                usage = "<player>"
                description = "원펀맨 야생에 플레이어를 추가합니다."
                CommandAdd()
            }
            component("remove") {
                usage = "<player>"
                description = "원펀맨 야생 플레이어를 제거합니다."
                CommandRemove()
            }
            component("list") {
                description = "플레이중인 플레이어 목록을 확인힙니다."
                CommandList()
            }
        }
    }
    private fun registerEvents() {
        server.pluginManager.registerEvents(BlockEvents(), this)
        server.pluginManager.registerEvents(EntityEvents(), this)
    }
}