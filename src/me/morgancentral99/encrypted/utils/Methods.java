package me.morgancentral99.encrypted.utils;

import org.bukkit.ChatColor;

public class Methods {
	
	public static String color(String text) {
		return text == null ? "" : ChatColor.translateAlternateColorCodes('&', text);
	}

}
