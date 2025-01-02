package fr.bearless.lobbymanager.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.bearless.lobbymanager.LobbyManager;
import fr.bearless.lobbymanager.Config.GetString;
import fr.bearless.lobbymanager.Config.SetInt;
import fr.bearless.lobbymanager.Config.SetString;

public class SetSpawnCmd implements CommandExecutor {
	
	final LobbyManager plugin;

    public SetSpawnCmd(LobbyManager main) {
        this.plugin = main;
    }

	@ Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[ ] args){
		
		if(label.equalsIgnoreCase("lobbymanager-setspawn") || label.equalsIgnoreCase("lm-setspawn") || label.equalsIgnoreCase("setspawn")){
			if(sender instanceof Player){
				Player player = (Player)sender;
				
				if(!player.hasPermission(GetString.getSetSpawnPermission())){
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getSetSpawnPermissionMessage()));
					return true;
				}
				
				if(args.length >= 1){
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getSetSpawnUsageMessage()));
					return true;
				}
				
				SetString.setSpawnWorldName(player);
				SetInt.setSpawnX(player);
				SetInt.setSpawnY(player);
				SetInt.setSpawnZ(player);
				SetInt.setSpawnYaw(player);
				SetInt.setSpawnPitch(player);
				
				plugin.saveDefaultConfig();
				
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getSetSpawnMessage()));
			}else{
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getOnlyPlayerMessage()));
			}
		}
		
		return false;
	}

}