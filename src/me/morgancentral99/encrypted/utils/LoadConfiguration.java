package me.morgancentral99.encrypted.utils;

import java.io.File;
import java.io.IOException;

import me.morgancentral99.encrypted.Main;

public class LoadConfiguration {
	
	private Main plugin;
	
	
	
	public LoadConfiguration(Main plugin) {
		this.plugin = plugin;
	}
	
	public void loadConfiguration() {
        plugin.getConfig().options().copyDefaults(true); 
        plugin.saveConfig();
	}
	
	public void loadExtraFiles() {
		plugin.IPFile = new File(plugin.subDir, "ips.yml");
		plugin.PlayerFile = new File(plugin.subDir, "players.yml");
		if(!plugin.subDir.exists()) {
			plugin.subDir.mkdir();
		}	
			if(!plugin.PlayerFile.exists()) {
			try {
				plugin.PlayerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} if(!plugin.IPFile.exists()) {
			try {
				plugin.IPFile.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	} 

}
