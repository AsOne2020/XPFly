package cn.asone.xpfly;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class IntervalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return false;
        try {
            XPFly plugin = XPFly.getPlugin(XPFly.class);
            XPFly.interval = Integer.parseInt(args[0]);
            plugin.config.set("interval", XPFly.interval);
            plugin.saveConfig();
            sender.sendMessage(String.format("§c[§6XPFly§c] §6成功设置§ainterval§6值为§a%d", XPFly.interval));
            return true;
        } catch (Exception ignored) {
            return false;
        }

    }
}
