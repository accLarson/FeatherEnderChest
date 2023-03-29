package dev.zerek.featherenderchest.listeners;

import dev.zerek.featherenderchest.FeatherEnderChest;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    private final FeatherEnderChest plugin;

    public BlockBreakListener(FeatherEnderChest plugin) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (event.getBlock().getType() == Material.ENDER_CHEST) {

            event.setDropItems(false);

            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OBSIDIAN,64));
        }
    }
}
