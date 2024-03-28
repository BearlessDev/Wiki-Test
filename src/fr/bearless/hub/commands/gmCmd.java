package fr.bearless.hub.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if(label.equalsIgnoreCase("gm")){
            if(sender instanceof Player){
                if(player.hasPermission("hub.admin.command.gm")){
                    if(args.length == 1){
                        if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")){
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage("§aVotre mode de jeux à été mis en §eCRÉATIF");
                        }
                        if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")){
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage("§aVotre mode de jeux à été mis en §eSURVIE");
                        }
                        if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")){
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage("§aVotre mode de jeux à été mis en §eAVENTURE");
                        }
                        if(args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp")){
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage("§aVotre mode de jeux à été mis en §eSPECTATEUR");
                        }
                    }else{
                        player.sendMessage("§c§lUsage: §c/gm <creative, survival, adventure, spectator>");
                    }
                }else{
                    player.sendMessage("§cVous n'avez pas la permission.");
                }
            }else{
                System.out.println("Seul un joueur peux faire cette commande.");
            }
        }
        return false;
    }
}
