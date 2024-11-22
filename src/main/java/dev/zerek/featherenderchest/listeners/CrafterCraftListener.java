package dev.zerek.featherenderchest.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CrafterCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CrafterCraftListener implements Listener {

    @EventHandler
    public void crafterCraft(CrafterCraftEvent event) {

        Material itemType = event.getRecipe().getResult().getType();

        if (itemType == Material.ENDER_CHEST) {
            event.setResult(ItemStack.empty());
            event.setCancelled(true);
        }
    }
}
