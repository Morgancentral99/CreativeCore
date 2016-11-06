package me.morgancentral99.encrypted.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RTP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player p = (Player)s;
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "/randomteleport 15000 15000 -f -w " + p.getWorld());
		}
		return false;
	}

}
