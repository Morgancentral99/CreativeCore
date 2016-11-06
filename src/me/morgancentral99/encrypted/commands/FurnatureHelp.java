package me.morgancentral99.encrypted.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class FurnatureHelp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
			s.sendMessage(ChatColor.DARK_RED + "------" + ChatColor.GOLD + " Furniture Help " + ChatColor.DARK_RED + "-----");
			s.sendMessage(ChatColor.GOLD + "To get Furniture: /Furniture give <FurnitureID> <amount>");
			s.sendMessage(ChatColor.GOLD + "To list Furniture: /Furniture list");
			s.sendMessage(ChatColor.GOLD + "Or At: https://goo.gl/ycxHfL");
			s.sendMessage(ChatColor.GOLD + "If you find a Furniture Addon that you would like PM A Staff Member");

			
		return true;
	}
	

}
