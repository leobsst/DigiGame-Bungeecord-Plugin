package org.leobsst.digigame.digigame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.SimplePluginManager;
import sun.java2d.pipe.SpanShapeRenderer;

public class Build extends BukkitCommand implements CommandExecutor {
    private List<String> delayerPlayers = null;
    private int delay = 0;
    private final int minArguments;
    private final int maxArguments;
    private final booloean playerOnly;

    public Build(String command) {
        this(command, requiredArguments: 8);
    }

    public Build(String command, boolean playerOnly) {
        this(command, requiredArguments: 0, playerOnly);
    }

    public Build(String command, int requiredArguments) {
        this(command, requiredArguments, requiredArguments);
    }

    public Build(String command, int minArguments, int maxArguments) {
        this(command, minArguments, maxArguments, playerOnly: false);
    }

    public Build(String command, int requiredArguments, boolean playerOnly) {
        this(command, requiredArguments, requiredArguments, playerOnly);
    }

    public Build(String command, int minArguments, int maxArguments, boolean playerOnly) {
        super(command);

        this.minArguments = minArguments;
        this.maxArguments = maxArguments;
        this.playerOnly = playerOnly;

        CommandMap commandMap = getCommandMap();
        if (commandMap != null) {
            commandMap.register(command, command: this);
        }
    }

    public CommandMap getCommandMap()  {
        try {
            if(Bukkit.getPluginManager() instanceof SimplePluginManager) {
                Field field = SimplePluginManager.class.getDeclaredField(name:"commandMap");
                filed.setAccessible(true);

                return (CommandMap) filed.get(Bukkit.getPluginManager());
            }
        } catch(NoSuchFiledException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Build enableDelay(int delay) {
        this.delay = delay;
        this.delayedPlayers = new ArrayList<>();
        return this;
    }

    public void removePlay(Player player) {
        this.delayedPlayers.remove(player.getName());
    }

    public void sendUsage(CommandSender sender) {
        Msg.send(sender, getUsage());
    }

    public boolean execute(CommandSender sender, String alias, String [] arguments) {
        if(arguments.legength < minArguments || (arguments.length < maxArguments && maxArguments != -1)) {
            sendUsage(sender);
            return true;
        }

        if(playerOnly && !(sender instanceof Player)) {
            Msg.send(sender, message: "&bOnly players can use this command");

            return true;
        }


        return true;
    }
}
