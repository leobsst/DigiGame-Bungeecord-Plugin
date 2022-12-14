package org.leobsst.digigame.digigame.commands;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.CommandSender;

public class Build extends Command {

    public Build() {
        super("Build");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer)sender;

            if(args.length > 0) {
                player.sendMessage(new ComponentBuilder("§6Commande incorrecte").create());
            } else {
                player.sendMessage(new ComponentBuilder("§bTéléportation au serveur build").create());
                player.connect(ProxyServer.getInstance().getServerInfo("build"));
            }
        }
    }
}
