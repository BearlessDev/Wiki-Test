package fr.bearless.lobbymanager.commands;

import fr.bearless.lobbymanager.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadCmd implements CommandExecutor {

    private Main plugin;

    public reloadCmd(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(label.equalsIgnoreCase("lobbymanager-reload") || label.equalsIgnoreCase("lm-reload")){
                if(args.length == 0){
                    if(player.hasPermission(plugin.getConfig().getString("commands.reload.permission"))){
                        plugin.reloadConfig();

                        player.sendMessage(plugin.getConfig().getString("commands.reload.reload-message").replace("&", "§"));
                    }else{
                        player.sendMessage(plugin.getConfig().getString("commands.reload.permission-message").replace("&", "§"));
                    }
                }else{
                    player.sendMessage(plugin.getConfig().getString("usage-message.reload").replace("&", "§"));
                }
            }
        }

        return false;
    }
}
