package me.morgancentral99.encrypted.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class StaffApp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("StaffApps")) {
			s.sendMessage(ChatColor.GOLD + "Check if Staff Applications are Open.");
			s.sendMessage(ChatColor.GOLD + "https://goo.gl/lGqdwv");
			return true;
			
		}
		return false;
	}

}
