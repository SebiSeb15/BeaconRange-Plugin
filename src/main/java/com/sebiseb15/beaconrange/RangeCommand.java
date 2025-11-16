package com.sebiseb15.beaconrange;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class RangeCommand implements CommandExecutor, TabCompleter {
    // fonctionne &
    private Plugin plugin = Bukkit.getPluginManager().getPlugin("BeaconRange");
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("get")) {
                if (args[1].startsWith("tier")) {
                    int tier = Integer.parseInt(args[1].substring(4));
                    if (plugin.getConfig().contains("range." + args[1])) {
                        double range  = plugin.getConfig().getDouble("range." + args[1]);
                        sender.sendMessage(ChatColor.GREEN + "The range for tier " + tier + " is " + ChatColor.YELLOW + range);
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "The tier " + tier + " doesn't exist!");
                        return true;
                    }


                }

            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("set")) {
                if (args[1].startsWith("tier")) {
                    int tier = Integer.parseInt(args[1].substring(4));
                    if (plugin.getConfig().contains("range." + args[1])) {
                        double range  = Integer.parseInt(args[2]);
                        plugin.getConfig().set("range." + args[1], range);
                        plugin.saveConfig();
                        sender.sendMessage(ChatColor.GREEN+"The range for tier " + tier + " has been set to "+ChatColor.YELLOW+range);
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED+"The tier " + tier + " doesn't exist!");
                        return true;
                    }
                }
            }

        }
        return false;
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        ArrayList<String> possibles = new ArrayList<>();

        switch (args.length) {
            case 1:
                possibles.add("get");
                possibles.add("set");
                break;
            case 2:
                possibles.add("tier1");
                possibles.add("tier2");
                possibles.add("tier3");
                possibles.add("tier4");

                break;
            case 3:
                possibles.add("[<range>]");
                break;
            default:
                break;
        }
        return possibles;
    }
}
