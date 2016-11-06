package me.morgancentral99.encrypted.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class SpawnCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			if(label.equalsIgnoreCase("spawn")) {
				Player p = (Player)s;
				if(args.length == 0) {
					runHelpCommand(s);
					return true;
				} else if(args[0].length() >= 1) {
					if(args[0].equalsIgnoreCase("flat")) {
						s.sendMessage(ChatColor.GOLD + "Teleporting to Flat Spawn!");
						Location loc = new Location(Bukkit.getWorld("World2"), 2342, 60, 117);
						loc.setYaw(180F);
						p.teleport(loc);
						return true;
					}else if(args[0].equalsIgnoreCase("Default")) {
						s.sendMessage(ChatColor.GOLD + "Teleporting to Default Spawn!");
						p.teleport(new Location(Bukkit.getWorld("Default"), -436, 79, 263));
						return true;
					} else if(args[0].equalsIgnoreCase("Plotworld")) {
						s.sendMessage(ChatColor.GOLD + "Teleporting to PlotWorld Spawn!");
						p.teleport(new Location(Bukkit.getWorld("Plotworld2"), -266, 65, -21));
						return true;
					}
				}
			}
		}
		return false;
	}

	private void runHelpCommand(CommandSender s) {
		s.sendMessage(ChatColor.DARK_BLUE + "-------" + ChatColor.GOLD + "Spawn Help " + ChatColor.DARK_BLUE + "-------");
		//s.sendMessage(ChatColor.GOLD + "/Spawn Server");
		s.sendMessage(ChatColor.GOLD + "/Spawn Flat");
		s.sendMessage(ChatColor.GOLD + "/Spawn Default");
		s.sendMessage(ChatColor.GOLD + "/Spawn PlotWorld");
	}
	
	

}
