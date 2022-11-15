package org.leobsst.digigame.digigame;

import net.md_5.bungee.api.plugin.Plugin;
import org.leobsst.digigame.digigame.commands.Build;
import org.leobsst.digigame.digigame.commands.Survie;

public final class Digigame extends Plugin {

    private static Digigame instance;

    @Override
    public void onEnable(){
        instance = this;

        getLogger().info("§6Plugin DigiGame has started");
        getProxy().getPluginManager().registerCommand(this, new Build());
        getProxy().getPluginManager().registerCommand(this, new Survie() );
    }

    public static Digigame getInstance() {
        return instance;
    }
}