package me.morgancentral99.encrypted.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.morgancentral99.encrypted.Main;
import net.md_5.bungee.api.ChatColor;

public class Methods {
	
	Main m;
	
    static boolean getClickedandBalance(Integer i, Player p) {
       if(Main.econ.bankWithdraw(p.getName(), i) != null) {
    	   return true;
       }
       p.sendMessage(ChatColor.RED + "Not enough Money");
    	return false;
    }
}
