package cn.asone.xpfly;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ToggleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID uuid = player.getUniqueId();
            if (XPFly.flyingState.containsKey(uuid)) {
                XPFly.flyingState.put(uuid, !XPFly.flyingState.get(uuid));
            } else {
                XPFly.flyingState.put(uuid, true);
            }
            player.sendMessage(String.format("§c[§6XPFly§c] §6经验飞行已%s！", XPFly.flyingState.get(uuid) ? "§a开启" : "§c关闭"));
        }
        return true;
    }
}
