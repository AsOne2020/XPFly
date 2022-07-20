package cn.asone.xpfly;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

import static cn.asone.xpfly.XPFly.*;

public class MyListener implements Listener {
    @EventHandler
    public void onPlayerMove(ServerTickStartEvent event) {
        for (Player player : server.getOnlinePlayers()) {
            UUID uuid = player.getUniqueId();
            if (flyingState.containsKey(uuid)) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    if (flyingState.get(uuid)) {
                        if (player.getTotalExperience() < cost) {
                            player.sendMessage("§c[§6XPFly§c] §c经验不足，已关闭飞行");
                            player.setAllowFlight(false);
                            flyingState.put(uuid, false);
                        } else {
                            if (player.getAllowFlight()) {
                                if (player.isFlying()) {
                                    if (flyingTicks.containsKey(uuid)) {
                                        flyingTicks.put(uuid, flyingTicks.get(uuid) + 1);
                                    } else {
                                        flyingTicks.put(uuid, 1);
                                    }
                                    if (flyingTicks.get(uuid) % interval == 0) {
                                        flyingTicks.put(uuid, 1);
                                        player.giveExp(-cost, false);
                                    }
                                }
                            } else {
                                player.setAllowFlight(true);
                            }
                        }
                    } else {
                        if (player.getAllowFlight() || player.isFlying()) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                        }
                    }
                }
            }
        }
    }
}
