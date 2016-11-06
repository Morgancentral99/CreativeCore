package me.morgancentral99.encrypted.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.morgancentral99.encrypted.Info;

public class Command implements Listener{ 
	
	Info i;
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		if(msg.startsWith("/pl") || msg.startsWith("/plugins") || msg.startsWith("/version") || msg.startsWith("/icanhasbukkit") || msg.startsWith("/bukkit:version") || msg.startsWith("/bukkit:plugins") || msg.startsWith("/bukkit:pl")) {
			e.setCancelled(true);
			p.sendMessage(i.getInfoPrefix() + "Encrypted Suites v1.0 By Morgancentral99");
		}
	}

}
