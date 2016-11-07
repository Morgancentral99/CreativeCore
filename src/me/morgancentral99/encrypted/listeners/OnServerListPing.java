package me.morgancentral99.encrypted.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.morgancentral99.encrypted.Main;

public class OnServerListPing implements Listener {

	private Main plugin;

	public OnServerListPing(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onServerListPing(ServerListPingEvent event) {
		String original1 = plugin.getConfig().getString("motd1");
		String original2 = plugin.getConfig().getString("motd2");
		String newMotd1 = ChatColor.translateAlternateColorCodes('&', original1);
		String newMotd2 = ChatColor.translateAlternateColorCodes('&', original2);
		newMotd1 = newMotd1;
		newMotd1 = newMotd1.substring(1);
		newMotd2 = newMotd2;
		newMotd2 = newMotd2.substring(1);
		String mainMotd = newMotd1 + "\n" + newMotd2;
		event.setMotd(mainMotd);
	}

}
