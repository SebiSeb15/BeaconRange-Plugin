package com.sebiseb15.beaconrange;

import com.destroystokyo.paper.event.block.BeaconEffectEvent;
import io.papermc.lib.PaperLib;

import java.io.File;


import org.bukkit.block.Beacon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class BeaconRange extends JavaPlugin implements Listener {
  private File configFile = new File(getDataFolder(), "config.yml");

  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);

    PaperLib.suggestPaper(this);

    if (!configFile.exists()) {
      saveDefaultConfig();
    } else {
      getLogger().info("Config file found !");
    }
    getConfig().addDefault("Range.Tier1", 20.0);
    getConfig().addDefault("Range.Tier2", 30.0);
    getConfig().addDefault("Range.Tier3", 40.0);
    getConfig().addDefault("Range.Tier4", 50.0);
    saveConfig();

    getLogger().info("BeaconRange has been enabled!");

    getCommand("beaconrange").setExecutor(new RangeCommand());
    getCommand("beaconrange").setTabCompleter(new RangeCommand());

  }

  @Override
  public void onDisable() {
    getLogger().info("BeaconRange has been disabled!");
  }


  @EventHandler
  public void onBeaconactivate(BeaconEffectEvent event) {
    Beacon b = (Beacon) event.getBlock().getState();
    int tier = b.getTier();
    double range = getConfig().getDouble("range.tier" + String.valueOf(tier));
    b.setEffectRange(range);
    b.update();
  }
}
