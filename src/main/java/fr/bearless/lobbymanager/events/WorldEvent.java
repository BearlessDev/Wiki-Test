package fr.bearless.lobbymanager.events;

import fr.bearless.lobbymanager.Config.GetBoolean;
import fr.bearless.lobbymanager.Config.GetString;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();

        if(GetBoolean.isBlockBreakEnabled()){
            if(player.hasPermission(GetString.getBlockBreakPermission())){
                if(player.getGameMode() == GameMode.CREATIVE){
                    e.setCancelled(false);
                }else{
                    e.setCancelled(true);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getBlockBreakPermissionMessage()));
                }
            }else{
                e.setCancelled(true);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getBlockBreakPermissionMessage()));
            }
        }
    }
    
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();

        if(GetBoolean.isBlockPlaceEnabled()){
            if(player.hasPermission(GetString.getBlockPlacePermission())){
                if(player.getGameMode() == GameMode.CREATIVE){
                    e.setCancelled(false);
                }else{
                    e.setCancelled(true);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getBlockPlacePermissionMessage()));
                }
            }else{
                e.setCancelled(true);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', GetString.getBlockPlacePermissionMessage()));
            }
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        if(GetBoolean.isWeatherChangeDisabled()){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){
        if(GetBoolean.isEntitySpawnDisabled()){
            e.setCancelled(true);
        }
    }
}