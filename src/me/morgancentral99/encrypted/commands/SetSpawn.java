package me.morgancentral99.encrypted.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;

public class SetSpawn implements CommandExecutor {
	
	private Main plugin;
	
	public SetSpawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("setspawn")) {
			if(sender instanceof Player) {
				FileConfiguration config = plugin.getConfig();
				Player player = (Player) sender;
				switch(args[0]) {
				case "PlotWorld":
					config.set("Spawn.PlotWorld", getNewSpawnLoc(player));
					sender.sendMessage("Set Spawn PlotWorld " + getNewSpawnLoc(player));
				case "Flat":
					config.set("Spawn.FlatWorld", getNewSpawnLoc(player));
					sender.sendMessage("Set Spawn FlatWorld " + getNewSpawnLoc(player));
				case "Default":
					config.set("Spawn.DefaultWorld", getNewSpawnLoc(player));
					sender.sendMessage("Set Spawn Default World " + getNewSpawnLoc(player));
			    default:
			    	sender.sendMessage(ChatColor.RED + "ERR...Invalid spawn!");
				}
			}
		}
		return false;
	}
	
	String getNewSpawnLoc(Player player) {
		Location loc = player.getLocation();
		Float pitch = loc.getPitch();
		Float yaw = loc.getYaw();
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		char dot = '.';
		String spawnLoc = String.valueOf(x) + dot + String.valueOf(y) + dot + String.valueOf(z) + dot + pitch + dot + yaw;
		return spawnLoc;
	}
	
}