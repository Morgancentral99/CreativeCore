package me.morgancentral99.encrypted.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;

public class SpawnCommands implements CommandExecutor {
	
	private Main plugin;
	
	public SpawnCommands(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			if(label.equalsIgnoreCase("spawn")) {
				Player player = (Player) sender;
				if(args.length == 0) {
					spawnCommands(player);
				} else if(args.length == 1) {
					switch(args[0]) {
					case "flat":
						player.teleport(getFlatSpawnLoc());
						break;
					case "default":
						player.teleport(getDefaultSpawnLoc());
						break;
					case "plotworld":
						player.teleport(getPlotSpawnLoc());
						break;
					default:
						spawnCommands(player);
					}
				} else {
					spawnCommands(player);
					return true;
				}
			}
		}
		return false;
	}

	void spawnCommands(Player player) {
		player.sendMessage(ChatColor.DARK_BLUE + "-------" + ChatColor.GOLD + "Spawn Help " + ChatColor.DARK_BLUE + "-------");
		//s.sendMessage(ChatColor.GOLD + "/Spawn Server");
		player.sendMessage(ChatColor.GOLD + "/Spawn Flat");
		player.sendMessage(ChatColor.GOLD + "/Spawn Default");
		player.sendMessage(ChatColor.GOLD + "/Spawn PlotWorld");
	}
	
	Location getFlatSpawnLoc() {
		String spawn = plugin.getConfig().getString("Spawn.FlatWorld");
		String[] spawnLoc = spawn.split(".");
		String x = spawnLoc[0];
		String y = spawnLoc[1];
		String z = spawnLoc[2];
		String pitch = spawnLoc[3];
		String yaw = spawnLoc[4];
		String world = spawnLoc[5];
		Float fpitch = Float.valueOf(pitch);
		Float fyaw = Float.valueOf(yaw);
		Location loc = new Location(Bukkit.getWorld(world), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z));
		loc.setYaw(fyaw);
		loc.setPitch(fpitch);
		return loc;
	}
	
	Location getDefaultSpawnLoc() {
		String spawn = plugin.getConfig().getString("Spawn.DefaultWorld");
		String[] spawnLoc = spawn.split(".");
		String x = spawnLoc[0];
		String y = spawnLoc[1];
		String z = spawnLoc[2];
		String pitch = spawnLoc[3];
		String yaw = spawnLoc[4];
		String world = spawnLoc[5];
		Float fpitch = Float.valueOf(pitch);
		Float fyaw = Float.valueOf(yaw);
		Location loc = new Location(Bukkit.getWorld(world), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z));
		loc.setYaw(fyaw);
		loc.setPitch(fpitch);
		return loc;
	}
	
	Location getPlotSpawnLoc() {
		String spawn = plugin.getConfig().getString("Spawn.PlotWorld");
		String[] spawnLoc = spawn.split(".");
		String x = spawnLoc[0];
		String y = spawnLoc[1];
		String z = spawnLoc[2];
		String pitch = spawnLoc[3];
		String yaw = spawnLoc[4];
		String world = spawnLoc[5];
		Float fpitch = Float.valueOf(pitch);
		Float fyaw = Float.valueOf(yaw);
		Location loc = new Location(Bukkit.getWorld(world), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z));
		loc.setYaw(fyaw);
		loc.setPitch(fpitch);
		return loc;
	}
	
	

}