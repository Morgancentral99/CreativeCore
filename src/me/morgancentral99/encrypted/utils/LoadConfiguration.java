package me.morgancentral99.encrypted.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;

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
		if (!plugin.subDir.exists()) {
			plugin.subDir.mkdir();
		}
		if (!plugin.PlayerFile.exists()) {
			try {
				plugin.PlayerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!plugin.IPFile.exists()) {
			try {
				plugin.IPFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveYamls() {
		try {
			plugin.Players.save(plugin.PlayerFile);
			plugin.IPS.save(plugin.IPFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadYamls() {
		try {
			plugin.Players.load(plugin.PlayerFile);
			plugin.IPS.load(plugin.IPFile);
		} catch (IOException | InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addYamlAlts(String username, String ip) {
		if (plugin.Players.getStringList(username) == null) {
			List<String> list = new ArrayList<>();
			list.add(ip);
			plugin.Players.addDefault(username, list);
		} else {
			List<String> list2 = plugin.Players.getStringList(username);
			if (!list2.contains(ip)) {
				list2.add(ip);
				plugin.Players.set(username, list2);
			}
		} try {
			plugin.Players.save(plugin.PlayerFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ip = ip.replaceAll("\\.", "_");
		if(plugin.IPS.getStringList(ip) == null) {
			List<String> list3 = new ArrayList<>();
			list3.add(username);
			plugin.IPS.addDefault(ip, list3);
		} else {
			List<String> list4 = plugin.IPS.getStringList(ip);
			Boolean d = Boolean.valueOf(false);
			for(String b : list4) {
				d = Boolean.valueOf(true);
			}
			if(!d.booleanValue()) {
				list4.add(username);
				plugin.IPS.set(ip, list4);
			}
			try {
				plugin.IPS.save(plugin.IPFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 

}
