package dev.zerek.featherenderchest.listeners;

import dev.zerek.featherenderchest.FeatherEnderChest;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreakListener implements Listener {

    private final FeatherEnderChest plugin;

    Random rand = new Random();

    public BlockBreakListener(FeatherEnderChest plugin) {

        this.plugin = plugin;
    }

    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {

        if (event.getBlock().getType() == Material.ENDER_CHEST && event.getPlayer().getGameMode() == GameMode.SURVIVAL) {

            event.setDropItems(false);

            int dropCount = rand.nextInt(57) + 8;

            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.OBSIDIAN, dropCount));
        }
    }
}
