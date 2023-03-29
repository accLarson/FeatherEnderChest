package com.zerek.featherenderchest.listeners;

import com.zerek.featherenderchest.FeatherEnderChest;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    private final FeatherEnderChest plugin;

    public PlayerInteractListener(FeatherEnderChest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getClickedBlock() != null) {

            if (Material.ENDER_CHEST == event.getClickedBlock().getType() && !event.getPlayer().hasPermission("feather.enderchest.access")) {

                if (event.getAction() == Action.LEFT_CLICK_BLOCK) {

                    event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize((String) plugin.getConfigMap().get("warn")));
                }

                else {
                    event.setCancelled(true);

                    event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize((String) plugin.getConfigMap().get("cancel")));
                }
            }
        }
    }
}
