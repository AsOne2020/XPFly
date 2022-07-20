package cn.asone.xpfly;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CostCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return false;
        try {
            XPFly plugin = XPFly.getPlugin(XPFly.class);
            XPFly.cost = Integer.parseInt(args[0]);
            plugin.config.set("cost", XPFly.cost);
            plugin.saveConfig();
            sender.sendMessage(String.format("§c[§6XPFly§c] §6成功设置§acost§6值为§a%d", XPFly.cost));
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
