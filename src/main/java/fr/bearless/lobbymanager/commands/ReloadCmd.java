package fr.bearless.lobbymanager.commands;

import fr.bearless.lobbymanager.Config.GetString;
import fr.bearless.lobbymanager.LobbyManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCmd implements CommandExecutor {

    final LobbyManager plugin;

    public ReloadCmd(LobbyManager main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(label.equalsIgnoreCase("lobbymanager-reload") || label.equalsIgnoreCase("lm-reload")){
                if(args.length == 0){
                    if(player.hasPermission(GetString.getReloadPermission())){
                        plugin.reloadConfig();

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getReloadMessage()));
                    }else{
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getReloadPermissionMessage()));
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getReloadUsageMessage()));
                }
            }
        }

        return false;
    }
}