package me.morgancentral99.encrypted;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.encrypted.commands.FurnatureHelp;
import me.morgancentral99.encrypted.commands.RTP;
import me.morgancentral99.encrypted.commands.SpawnCommands;
import me.morgancentral99.encrypted.commands.StaffApp;
import me.morgancentral99.encrypted.listeners.OnJoin;
import me.morgancentral99.encrypted.listeners.OnServerListPing;
import me.morgancentral99.encrypted.listeners.Weather;
import me.morgancentral99.encrypted.utils.Logger;

public class Main extends JavaPlugin {
	Main m;
	
	FileConfiguration config = getConfig(); 
	
	boolean maintenceEnabled = false;

	private PluginDescriptionFile pdf = getDescription();

	@Override
	public void onEnable() {
		Logger.info("Loaded: " + pdf.getName());
		m = this;
		registerCommands();
		registerListeners();
		config.addDefault("maitenceMode", false);
		config.addDefault("motd1", "s&4Morgan likes it from behind.");
		config.addDefault("motd2", "s&aFrom brocoli.");
		config.options().copyDefaults(true);
		saveConfig();
	}

	public boolean isMaintenceEnabled() {
		return maintenceEnabled;
	}

	public void setMaintenceEnabled(boolean maintenceEnabled) {
		this.maintenceEnabled = maintenceEnabled;
	}

	@Override
	public void onDisable() {
		Logger.info("Disabled: " + pdf.getName());
	}

	public void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		//pm.registerEvents(new Command(), this);
		pm.registerEvents(new Weather(), this);
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnServerListPing(this), this);
		
	}

	
	public void registerCommands() {
		this.getCommand("spawn").setExecutor(new SpawnCommands());
		this.getCommand("StaffApps").setExecutor(new StaffApp());
	//	this.getCommand("RTP").setExecutor(new RTP());
		this.getCommand("furniturehelp").setExecutor(new FurnatureHelp());
	//	this.getCommand("maintence").setExecutor(new Maintence());
	}

}
