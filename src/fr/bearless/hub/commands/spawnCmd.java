package fr.bearless.hub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("lobby")){
            if(sender instanceof Player){
                if(args.length == 0){
                    World spawn = Bukkit.getWorld("World");
                    Location loc = new Location(spawn, 0.500, 65.1, 0.500, 180, 0);

                    player.teleport(loc);
                }
            }
        }

        if(label.equalsIgnoreCase("hub")){
            if(sender instanceof Player){
                if(args.length == 0){
                    player.sendMessage("§cCette commande n'est pas encore disponible.");
                }
            }
        }
        return false;
    }
}
