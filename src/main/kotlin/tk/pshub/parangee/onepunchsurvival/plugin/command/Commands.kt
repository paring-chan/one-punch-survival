package tk.pshub.parangee.onepunchsurvival.plugin.command

import com.github.noonmaru.tap.command.ArgumentList
import com.github.noonmaru.tap.command.CommandComponent
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import tk.pshub.parangee.onepunchsurvival.plugin.OnePunchSurvival

private val pl = Bukkit.getPluginManager().getPlugin("OnePunchSurvival") as OnePunchSurvival

class CommandAdd : CommandComponent {
    override val argsCount: Int = 1
    override fun onCommand(sender: CommandSender, label: String, componentLabel: String, args: ArgumentList): Boolean {
        var player = Bukkit.getPlayer(args.last())
        if (player != null) {
            if (player.isOnline) {
                pl.players.add(player)
                sender.sendMessage("${player.displayName}님이 플레이어 목록에 추가되었습니다.")
            } else {
                sender.sendMessage("플레이어 ${player.displayName}님이 온라인이 아닙니다.")
            }
        } else {
            sender.sendMessage("플레이어 를 찾을수 없습니다.")
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        label: String,
        componentLabel: String,
        args: ArgumentList
    ): List<String> {
        var list = ArrayList<String>()
        Bukkit.getOnlinePlayers().forEach {
            if (!pl.players.contains(it)) {
                if (it.name.toLowerCase().contains(args.last().toLowerCase())) {
                    list.add(it.displayName)
                }
            }
        }
        return list
    }
}

class CommandRemove : CommandComponent {
    override val argsCount: Int = 1
    override fun onCommand(sender: CommandSender, label: String, componentLabel: String, args: ArgumentList): Boolean {
        var player = Bukkit.getPlayer(args.last())
        if (player != null) {
            if (player.isOnline) {
                pl.players.add(player)
                sender.sendMessage("${player.displayName}님이 플레이어 목록에서 제거되었습니다.")
            } else {
                sender.sendMessage("플레이어 ${player.displayName}님이 온라인이 아닙니다.")
            }
        } else {
            sender.sendMessage("플레이어 를 찾을수 없습니다.")
        }
        return true
    }
    override fun onTabComplete(
        sender: CommandSender,
        label: String,
        componentLabel: String,
        args: ArgumentList
    ): List<String> {
        var list = ArrayList<String>()
        Bukkit.getOnlinePlayers().forEach {
            if (pl.players.contains(it)) {
                if (it.name.toLowerCase().contains(args.last().toLowerCase())) {
                    list.add(it.displayName)
                }
            }
        }
        return list
    }
}
class CommandList : CommandComponent {
    override fun onCommand(sender: CommandSender, label: String, componentLabel: String, args: ArgumentList): Boolean {
        sender.sendMessage("원펀맨 야생 플레이어 리스트 - ${pl.players.size}")
        pl.players.forEach {
            sender.sendMessage(it.displayName)
        }
        return true
    }
}