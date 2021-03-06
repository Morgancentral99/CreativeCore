package me.morgancentral99.encrypted;

import java.io.File;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.encrypted.commands.FurnatureHelp;
import me.morgancentral99.encrypted.commands.SetSpawn;
import me.morgancentral99.encrypted.commands.SpawnCommands;
import me.morgancentral99.encrypted.commands.StaffApp;
import me.morgancentral99.encrypted.inventories.Shop;
import me.morgancentral99.encrypted.listeners.OnJoin;
import me.morgancentral99.encrypted.listeners.OnServerListPing;
import me.morgancentral99.encrypted.listeners.Weather;
import me.morgancentral99.encrypted.utils.LoadConfiguration;
import me.morgancentral99.encrypted.utils.Logger;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	Main m;
	LoadConfiguration lc;
	
	FileConfiguration config = getConfig(); 
	
	public File PlayerFile;
	public File IPFile;
	public FileConfiguration Players;
	public FileConfiguration IPS;
	public File subDir = new File("plugins/CreativeCore/AltInfo");
	
	boolean maintenceEnabled = false;
	
	private HashSet<String> AltList = new HashSet();

	private PluginDescriptionFile pdf = getDescription();
	public static Economy econ = null;

	@Override
	public void onEnable() {
		Logger.info("Loaded: " + pdf.getName());
		this.m = this;
		registerCommands();
		registerListeners();
	//	lc.loadExtraFiles();
	    this.config.addDefault("maitenceMode", Boolean.valueOf(false));
	    this.config.addDefault("motd1", "s&0-----&7=====&0[&6Encrypted Creative&0]&7=====&0-----");
	    this.config.addDefault("motd2", "s&6[1.10]  &0[&3Fixed Lag out Issues&0]");
	    this.config.addDefault("Spawn.FlatWorld", "0.0.0.0.0.world");
	    this.config.addDefault("Spawn.DefaultWorld", "0.0.0.0.0.world");
	    this.config.addDefault("Spawn.PlotWorld", "0.0.0.0.0.world");
	    this.config.options().copyDefaults(true);
	    saveConfig();
	    if(!setupEconomy()) {
			getServer().getPluginManager().disablePlugin(this);
		}
		this.Players = new YamlConfiguration();
		this.IPS = new YamlConfiguration();
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
		pm.registerEvents(new OnJoin(this), this);
		pm.registerEvents(new OnServerListPing(this), this);
		pm.registerEvents(new Shop(), this);
		
	}
	
	
	public void registerCommands() {
		this.getCommand("spawn").setExecutor(new SpawnCommands(this));
		this.getCommand("StaffApps").setExecutor(new StaffApp());
		this.getCommand("SetSpawn").setExecutor(new SetSpawn(this));
	//	this.getCommand("Shop").setExecutor(new me.morgancentral99.encrypted.commands.Shop());
	//	this.getCommand("RTP").setExecutor(new RTP());
		this.getCommand("furniturehelp").setExecutor(new FurnatureHelp());
	//	this.getCommand("maintence").setExecutor(new Maintence());
	}
	
	private boolean setupEconomy() {
		if(getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
	}

}
