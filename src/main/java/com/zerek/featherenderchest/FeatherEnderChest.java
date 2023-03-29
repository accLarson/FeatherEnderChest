package com.zerek.featherenderchest;

import com.zerek.featherenderchest.listeners.BlockPlaceListener;
import com.zerek.featherenderchest.listeners.PlayerInteractListener;
import com.zerek.featherenderchest.listeners.PrepareItemCraftListener;
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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<String, Object> getConfigMap() {
        return configMap;
    }
}
