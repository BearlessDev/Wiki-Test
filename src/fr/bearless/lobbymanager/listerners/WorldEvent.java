package fr.bearless.lobbymanager.listerners;

import fr.bearless.lobbymanager.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldEvent implements Listener {

    private Main plugin;

    public WorldEvent(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("world.block-break.enable")){
            if(player.hasPermission(plugin.getConfig().getString("world.block-break.permission").replace("&", "§"))){
                if(player.getGameMode() == GameMode.CREATIVE){
                    e.setCancelled(false);
                }else{
                    e.setCancelled(true);

                    player.sendMessage(plugin.getConfig().getString("world.block-break.permission-message").replace("&", "§"));
                }
            }else{
                e.setCancelled(true);

                player.sendMessage(plugin.getConfig().getString("world.block-break.permission-message").replace("&", "§"));
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("world.block-place.enable")){
            if(player.hasPermission(plugin.getConfig().getString("world.block-place.permission").replace("&", "§"))){
                if(player.getGameMode() == GameMode.CREATIVE){
                    e.setCancelled(false);
                }else{
                    e.setCancelled(true);

                    player.sendMessage(plugin.getConfig().getString("world.block-place.permission-message").replace("&", "§"));
                }
            }else{
                e.setCancelled(true);

                player.sendMessage(plugin.getConfig().getString("world.block-place.permission-message").replace("&", "§"));
            }
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){

        if(plugin.getConfig().getBoolean("world.disable-weather-change")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e){

        if(plugin.getConfig().getBoolean("world.disable-entity-spawn")){
            e.setCancelled(true);
        }
    }
}
