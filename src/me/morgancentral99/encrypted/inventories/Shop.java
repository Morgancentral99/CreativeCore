package me.morgancentral99.encrypted.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Shop implements Listener {
	
	private Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Shop");
	
	
	private ItemStack exit = new ItemStack(Material.BARRIER);
	private ItemStack UntouchableTag = new ItemStack(Material.STAINED_GLASS_PANE);
	
	public void getShopInv(Player p) {
		
		ItemMeta uMeta = UntouchableTag.getItemMeta();
		uMeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Untouchable" + ChatColor.GRAY + "]");
		List<String> uLore = new ArrayList<>();
		uLore.add(ChatColor.DARK_PURPLE + "Cost: $10,500");
		uMeta.setLore(uLore);
		UntouchableTag.setItemMeta(uMeta);
		
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName(ChatColor.AQUA + "Exit");
        exit.setItemMeta(exitMeta);
		
        inv.setItem(0, UntouchableTag);
        inv.setItem(8, exit);
        
        p.openInventory(inv);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p =(Player)e.getWhoClicked();
		ItemStack Clicked = e.getCurrentItem();
		Inventory i = e.getInventory();
		
		if(i.getName().equals(inv)) {
			if(Clicked.equals(UntouchableTag)) {
				if(Methods.getClickedandBalance(2000, p)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add deluxetags.tag.tag1");
					p.sendMessage(ChatColor.GREEN + "Bought: " + ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Untouchable" + ChatColor.GRAY + "]");
					e.setCancelled(true);
				}
			} else if(Clicked.equals(exit)) {
				p.closeInventory();
				e.setCancelled(true);
			}
		
		}
	
				
	}
	
	

}
