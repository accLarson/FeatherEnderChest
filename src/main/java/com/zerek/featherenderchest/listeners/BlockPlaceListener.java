package com.zerek.featherenderchest.listeners;

import com.zerek.featherenderchest.FeatherEnderChest;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    private final FeatherEnderChest plugin;

    public BlockPlaceListener(FeatherEnderChest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (event.getBlock().getType() == Material.ENDER_CHEST && !event.getPlayer().hasPermission("feather.enderchest.access")){
            event.setCancelled(true);
            event.getPlayer().sendActionBar(MiniMessage.get().parse((String) plugin.getConfigMap().get("cancel-actionbar")));


        }
    }
}
