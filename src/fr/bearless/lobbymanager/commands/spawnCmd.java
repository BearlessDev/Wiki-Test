package fr.bearless.lobbymanager.commands;

import fr.bearless.lobbymanager.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class spawnCmd implements CommandExecutor {

    private Main plugin;

    public spawnCmd(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("lobbymanager-spawn") || label.equalsIgnoreCase("lm-spawn") || label.equalsIgnoreCase("spawn")){
            if(sender instanceof Player){
                Player player = (Player) sender;

                String world = plugin.getConfig().getString("world.spawn_world_name");
                Double spawnX = plugin.getConfig().getDouble("world.spawn_X");
                Double spawnY = plugin.getConfig().getDouble("world.spawn_Y");
                Double spawnZ = plugin.getConfig().getDouble("world.spawn_Z");
                int spawnYaw = plugin.getConfig().getInt("world.spawn_Yaw");
                int spawnPitch = plugin.getConfig().getInt("world.spawn_Pitch");
                Location loc = new Location(Bukkit.getWorld(world), spawnX, spawnY, spawnZ, spawnYaw, spawnPitch);

                player.teleport(loc);
                player.sendMessage(plugin.getConfig().getString("command.spawn.message"));
            }
        }
        return false;
    }
}
