package fr.bearless.lobbymanager.listerners;

import fr.bearless.lobbymanager.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayersEvent implements Listener {

    private Main plugin;

    public PlayersEvent(Main main){
        this.plugin = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("server.disable_default_join_message")){
            e.setJoinMessage("");
        }else{
            e.setJoinMessage(plugin.getConfig().getString("server.custom_join_message").replace("&", "§").replaceAll("%player%", player.getName()));
        }

        player.setHealth(plugin.getConfig().getInt("player.player_health_level"));
        player.setFoodLevel(plugin.getConfig().getInt("player.player_food_level"));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("server.disable_default_join_message")){
            e.setQuitMessage("");
        }else{
            e.setQuitMessage(plugin.getConfig().getString("server.custom_join_message").replace("&", "§").replaceAll("%player%", player.getName()));
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        EntityDamageEvent.DamageCause cause = e.getCause();

        if(plugin.getConfig().getBoolean("player.disable_fall_damage")){
            if(cause == EntityDamageEvent.DamageCause.FALL){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHealthChange(EntityRegainHealthEvent e){
        if(plugin.getConfig().getBoolean("player.disable_fall_damage")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){

        if(plugin.getConfig().getBoolean("player.disable_food_loss")){
            e.setCancelled(true);
        }
    }
}
