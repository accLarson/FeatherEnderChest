package dev.zerek.featherenderchest;

import dev.zerek.featherenderchest.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class FeatherEnderChest extends JavaPlugin {

    private final HashMap<String,Object> configMap = new HashMap<>();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        getConfig().getKeys(false).forEach(c -> configMap.put(c,getConfig().get(c)));

        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(this),this);
        this.getServer().getPluginManager().registerEvents(new PrepareItemCraftListener(this),this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(this),this);
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(this),this);
        this.getServer().getPluginManager().registerEvents(new CrafterCraftListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<String, Object> getConfigMap() {
        return configMap;
    }
}
