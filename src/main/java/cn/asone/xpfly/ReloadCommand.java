package cn.asone.xpfly;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        XPFly plugin = XPFly.getPlugin(XPFly.class);
        plugin.reloadConfig();
        plugin.config = plugin.getConfig();
        plugin.config.addDefault("cost", 1);
        plugin.config.addDefault("interval", 2);
        plugin.config.options().copyDefaults(true);
        XPFly.cost = plugin.config.getInt("cost");
        XPFly.interval = plugin.config.getInt("interval");
        plugin.saveConfig();

        sender.sendMessage("§c[§6XPFly§c] §6成功重载配置");
        return true;
    }
}
