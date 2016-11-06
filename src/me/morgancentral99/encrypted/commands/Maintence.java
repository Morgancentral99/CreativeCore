package me.morgancentral99.encrypted.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;

public class Maintence implements CommandExecutor {
	
	Main m;

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("Maintence")) {
			if(args.length == 0) {
				setMaintenceMode(true);
			}
		}
		return false;
	}

	private void setMaintenceMode(boolean b) {
		if(b == true) {
			Bukkit.broadcastMessage(ChatColor.GOLD + "Maintence Mode Activated Come back soon!");
			m.getConfig().set("maintenceMode", true);
			m.setMaintenceEnabled(true);
		}
		
	}
	
	

}
