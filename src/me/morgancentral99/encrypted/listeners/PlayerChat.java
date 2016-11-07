package me.morgancentral99.encrypted.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChat
  implements Listener
{
  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent event)
  {
    if (event.getPlayer().getName().equalsIgnoreCase("morgancentral99")) {
      event.setFormat(ChatColor.BLACK + "[" + ChatColor.RED + "Owner" + ChatColor.BLACK + "]" + 
        ChatColor.RED + " Morgan" + ChatColor.BLACK + " : " + ChatColor.RED + event.getMessage());
    } else if (event.getPlayer().getName().equalsIgnoreCase("karateman2400")) {
      event.setFormat(ChatColor.BLACK + "[" + ChatColor.RED + "Co-Owner" + ChatColor.BLACK + "]" + 
        ChatColor.RED + " Justin" + ChatColor.BLACK + " : " + ChatColor.RED + event.getMessage());
    }
  }
}
