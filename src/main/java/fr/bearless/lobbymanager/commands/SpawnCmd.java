package fr.bearless.lobbymanager.commands;

import fr.bearless.lobbymanager.Config.GetInt;
import fr.bearless.lobbymanager.Config.GetString;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("lobbymanager-spawn") || label.equalsIgnoreCase("lm-spawn") || label.equalsIgnoreCase("spawn")){
            if(sender instanceof Player){
                Player player = (Player) sender;

                String world = GetString.getSpawnWorldName();
                double spawnX = GetInt.getSpawnX();
                double spawnY = GetInt.getSpawnY();
                double spawnZ = GetInt.getSpawnZ();
                float spawnYaw = (float) GetInt.getSpawnYaw();
                float spawnPitch = (float) GetInt.getSpawnPitch();
                Location loc = new Location(Bukkit.getWorld(world), spawnX, spawnY, spawnZ, spawnYaw, spawnPitch);

                player.teleport(loc);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getSpawnCommandMessage()));
            }else{
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getOnlyPlayerMessage()));
			}
        }
        return false;
    }
}