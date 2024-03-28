package fr.bearless.hub.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class world implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){

        if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();

        if(player.hasPermission("hub.event.block.break")){
            if(player.getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
                player.sendMessage("§cVous pouvez pas casser de blocs.");
            }
        }else{
            e.setCancelled(true);
            player.sendMessage("§cVous pouvez pas casser de blocs.");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();

        if(player.hasPermission("hub.event.block.place")){
            if(player.getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
                player.sendMessage("§cVous pouvez pas placer de blocs.");
            }
        }else{
            e.setCancelled(true);
            player.sendMessage("§cVous pouvez pas placer de blocs.");
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        e.setCancelled(true);
    }
}
