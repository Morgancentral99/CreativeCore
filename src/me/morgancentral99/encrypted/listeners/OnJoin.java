package me.morgancentral99.encrypted.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.morgancentral99.encrypted.Main;
import me.morgancentral99.encrypted.utils.LoadConfiguration;

public class OnJoin implements Listener {
	Main m;
	LoadConfiguration lc;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	//	if(m.getConfig().getBoolean("maitenceMode")) {
	//		e.getPlayer().kickPlayer(ChatColor.GOLD + "Server in Maintence Mode, Check back Later!");
	//	}
		
		p.setGameMode(GameMode.CREATIVE);
		if(!(e.getPlayer().hasPlayedBefore())) {
			Location loc = new Location(Bukkit.getWorld("World2"), 2342, 60, 117);
			loc.setYaw(180F);
			p.teleport(loc);
		}
	}

}
