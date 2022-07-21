package cn.asone.xpfly;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class FallDamageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        XPFly plugin = XPFly.getPlugin(XPFly.class);
        XPFly.fallDamage = !XPFly.fallDamage;
        plugin.config.set("fallDamage", XPFly.fallDamage);
        plugin.saveConfig();
        sender.sendMessage(String.format("§c[§6XPFly§c] §6经验飞行摔落伤害已%s！", XPFly.fallDamage? "§a开启" : "§c关闭"));
        return true;
    }
}
