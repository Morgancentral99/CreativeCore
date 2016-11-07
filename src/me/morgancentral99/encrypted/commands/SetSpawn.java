package me.morgancentral99.encrypted.commands;

import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
	
	  private Main plugin;
	  
	  public SetSpawn(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    if ((command.getName().equalsIgnoreCase("setspawn")) && 
	      ((sender instanceof Player)))
	    {
	      FileConfiguration config = this.plugin.getConfig();
	      Player player = (Player)sender;
	      String str;
	      switch ((str = args[0]).hashCode())
	      {
	      case -1085510111: 
	        if (str.equals("Default")) {}
	        break;
	      case -484072687: 
	        if (str.equals("PlotWorld")) {
	          break;
	        }
	        break;
	      case 2192281: 
	        if (!str.equals("Flat"))
	        {
	      //    break label158;
	          config.set("Spawn.PlotWorld", getNewSpawnLoc(player));
	        }
	        else
	        {
	          config.set("Spawn.FlatWorld", getNewSpawnLoc(player));
	          
	          config.set("Spawn.DefaultWorld", getNewSpawnLoc(player));
	        }
	        break;
	      }
	      label158:
	      sender.sendMessage(ChatColor.RED + "ERR...Invalid spawn!");
	    }
	    return false;
	  }
	  
	  String getNewSpawnLoc(Player player)
	  {
	    Location loc = player.getLocation();
	    Float pitch = Float.valueOf(loc.getPitch());
	    Float yaw = Float.valueOf(loc.getYaw());
	    double x = loc.getX();
	    double y = loc.getY();
	    double z = loc.getZ();
	    char dot = '.';
	    String spawnLoc = String.valueOf(x) + dot + String.valueOf(y) + dot + String.valueOf(z) + dot + pitch + dot + yaw;
	    return spawnLoc;
	  }
}


