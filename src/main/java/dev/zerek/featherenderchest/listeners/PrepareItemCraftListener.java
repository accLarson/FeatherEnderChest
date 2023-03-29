package dev.zerek.featherenderchest.listeners;

import dev.zerek.featherenderchest.FeatherEnderChest;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class PrepareItemCraftListener implements Listener {
    private final FeatherEnderChest plugin;

    public PrepareItemCraftListener(FeatherEnderChest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void craftItem(PrepareItemCraftEvent event) {

        if (event.getRecipe() != null) {

            Material itemType = event.getRecipe().getResult().getType();

            if (itemType == Material.ENDER_CHEST && !event.getViewers().stream().allMatch(he -> he.hasPermission("feather.enderchest.access"))) {

                event.getInventory().setResult(new ItemStack(Material.AIR));

                event.getViewers().forEach(he -> he.sendMessage(MiniMessage.miniMessage().deserialize((String) plugin.getConfigMap().get("cancel"))));

                event.getInventory().close();
            }
        }
    }
}
