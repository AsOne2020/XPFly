package cn.asone.xpfly;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class XPFly extends JavaPlugin {

    public FileConfiguration config = this.getConfig();
    public static HashMap<UUID, Boolean> flyingState = new HashMap<>();
    public static HashMap<UUID, Integer> flyingTicks = new HashMap<>();
    public static int cost = 1;
    public static int interval = 1;
    public static Server server;

    @Override
    public void onEnable() {
        server = getServer();

        config.addDefault("cost", 1);
        config.addDefault("interval", 2);

        config.options().copyDefaults(true);

        cost = config.getInt("cost");
        interval = config.getInt("interval");
        saveConfig();

        getCommand("xpflytoggle").setExecutor(new ToggleCommand());
        getCommand("xpflyreload").setExecutor(new ReloadCommand());
        getCommand("xpflycost").setExecutor(new CostCommand());
        getCommand("xpflyinterval").setExecutor(new IntervalCommand());
        getServer().getPluginManager().registerEvents(new MyListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.saveConfig();
    }

}
