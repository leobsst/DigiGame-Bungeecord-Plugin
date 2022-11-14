package org.leobsst.digigame.digigame;

import org.bukkit.Bukkit;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Digigame extends JavaPlugin {
    private static Digigame instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("§b Digigame plugin started");
        getCommand( name: "build");
    }

    @Override
    public void onDisable() { System.out.println("§b Digigame plugin stopped"); }

    public static Digigame getInstance() {
        return instance;
    }
}
