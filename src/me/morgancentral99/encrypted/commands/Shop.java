package me.morgancentral99.encrypted.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Shop implements CommandExecutor {
	
	me.morgancentral99.encrypted.inventories.Shop sh;

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player p = (Player)s;
			sh.getShopInv(p);
			p.sendMessage(ChatColor.GOLD + "Opening Shop");
			return true;
		}
		return false;
	}

}
