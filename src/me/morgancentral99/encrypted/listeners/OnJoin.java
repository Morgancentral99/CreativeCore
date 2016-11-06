package me.morgancentral99.encrypted.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.morgancentral99.encrypted.HashMaps;
import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;

public class OnJoin implements Listener {
	Main m;
	HashMaps hm;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(m.getConfig().getBoolean("maitenceMode")) {
			if(hm.Staff.contains(p.getName())) {
				return;
			}
			e.getPlayer().kickPlayer(ChatColor.GOLD + "Server in Maintence Mode, Check back Later!");
		}
		if(!(e.getPlayer().hasPlayedBefore())) {
			Location loc = new Location(Bukkit.getWorld("World2"), 2342, 60, 117);
			loc.setYaw(180F);
			p.teleport(loc);
		}
	}

}