package me.morgancentral99.encrypted.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;

public class Methods {
	
    static boolean getClickedandBalance(Integer i, Player p, InventoryClickEvent e) {
        if (PlayerManager.balances.get(p.getName()) >= i) {
            int w = PlayerManager.balances.get(p.getName());
            PlayerManager.balances.put(p.getName(), w - i);
            return true;
        }
        if (PlayerManager.balances.get(p.getName()) == null) {
            p.sendMessage(ChatColor.RED + "Returned Null, Relog to fix!");
            e.setCancelled(true);
        }

        p.sendMessage(ChatColor.RED + "Not Enough Funds");
        e.setCancelled(true);
        return false;
    }

}
