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
import net.md_5.bungee.api.ChatColor;

public class OnJoin implements Listener {
	LoadConfiguration lc;
	
	  private Main plugin;
	  
	  public OnJoin(Main plugin)
	  {
	    this.plugin = plugin;
	  }

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.getName().equalsIgnoreCase("karateman2400")) {
			p.setPlayerListName(ChatColor.RED + "Justin");
		} else if (p.getName().equalsIgnoreCase("morgancentral99")) {
			p.setPlayerListName(ChatColor.RED + "Morgancentral99");
		}
		p.setGameMode(GameMode.CREATIVE);
		if (!e.getPlayer().hasPlayedBefore()) {
			String spawn = this.plugin.getConfig().getString("Spawn.FlatWorld");
			String[] spawnLoc = spawn.split(".");
			String x = spawnLoc[0];
			String y = spawnLoc[1];
			String z = spawnLoc[2];
			String pitch = spawnLoc[3];
			String yaw = spawnLoc[4];
			String world = spawnLoc[5];
			Float fpitch = Float.valueOf(pitch);
			Float fyaw = Float.valueOf(yaw);
			Location loc = new Location(Bukkit.getWorld(world), Integer.valueOf(x).intValue(),
					Integer.valueOf(y).intValue(), Integer.valueOf(z).intValue());
			loc.setYaw(fyaw.floatValue());
			loc.setPitch(fpitch.floatValue());
			p.teleport(loc);
		}
	}
}
