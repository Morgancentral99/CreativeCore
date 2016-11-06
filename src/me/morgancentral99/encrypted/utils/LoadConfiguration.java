package me.morgancentral99.encrypted.utils;

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

}
