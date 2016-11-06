package me.morgancentral99.encrypted.utils;

import org.bukkit.Bukkit;


public class Logger {
    private static java.util.logging.Logger logger = Bukkit.getLogger();

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void severe(String msg) {
        logger.severe(msg);
    }

}