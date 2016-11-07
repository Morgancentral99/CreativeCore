package me.morgancentral99.encrypted.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.morgancentral99.encrypted.utils.Methods;

public class AltChecker implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("Alts")) {
			if(s.hasPermission("Core.Staff")) {
				if(args.length < 1) {
					s.sendMessage(Methods.color("&c------ &Alt Checker &c------"));
					s.sendMessage(ChatColor.RED + "Usage: /Alts <PlayerName>");
				}
			}
			s.sendMessage(ChatColor.RED + "No permissions!");
		}
		return false;
	}

}
