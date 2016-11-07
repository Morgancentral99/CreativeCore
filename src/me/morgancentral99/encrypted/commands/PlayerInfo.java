package me.morgancentral99.encrypted.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.morgancentral99.encrypted.Main;
import me.morgancentral99.encrypted.utils.Methods;
import net.md_5.bungee.api.ChatColor;

public class PlayerInfo implements CommandExecutor {
	Main m;

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		Player p = (Player)s;
 		if(cmd.getName().equalsIgnoreCase("PlayerInfo")) {
			if(p.hasPermission("Core.staff")) {
				if(args.length < 0) {
					s.sendMessage(ChatColor.RED + "/Playerinfo <Username>");
				}
				Player p2 = m.getServer().getPlayer(args[0]);
				s.sendMessage(Methods.color("&c------ &6PlayerInfo &c------"));
				s.sendMessage(Methods.color("&6Name: &c" + p2.getName()));
				s.sendMessage(Methods.color("&6Display Name: &c" + p2.getDisplayName()));
				s.sendMessage(Methods.color("&6UUID: &c" + p2.getUniqueId()));
				s.sendMessage(Methods.color("&6IP: &c" + p2.getAddress().getAddress()));
				s.sendMessage(Methods.color("&6World: &c" + p2.getWorld()));
				s.sendMessage(Methods.color("&6OP: &c" + p2.isOp()));
				s.sendMessage(Methods.color("&6Balance: &c" + m.econ.getBalance(p2)));
			}
		}
		return false;
	}
	
	

}
