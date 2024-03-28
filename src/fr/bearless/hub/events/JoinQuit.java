package fr.bearless.hub.events;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.*;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String lpPrefix = user.getCachedData().getMetaData().getPrefix().replace("&", "§");
        World world = Bukkit.getWorld("World");
        Location loc = new Location(world, 0.500, 65.1, 0.500, 180, 0);

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassM = compass.getItemMeta();
        compassM.setDisplayName("§cMenu Principal");
        compass.setItemMeta(compassM);

        player.getInventory().setItem(0, compass);

        player.getInventory().clear();
        player.setCompassTarget(loc);
        player.teleport(loc);
        player.setLevel(0);
        player.setExp(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendTitle("§aBienvenue sur §eBearlessServ", "§7Amuse toi bien");
        player.sendMessage(lpPrefix + player.getName() + " §avient de rejoindre le serveur.");

        if(player.hasPermission("hub.admin.fly")){
            player.setAllowFlight(true);
            player.setFlying(true);
        }

        e.setJoinMessage("");

        for(Player players : world.getPlayers()){
            players.sendMessage(lpPrefix + player.getName() + " §avient de rejoindre le serveur.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("");
    }
}
