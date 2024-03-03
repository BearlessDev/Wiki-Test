package fr.bearless.lobbymanager.listerners;

import fr.bearless.lobbymanager.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WorldEvent implements Listener {

    private Main plugin;

    public WorldEvent(Main main) {
        this.plugin = main;
    }

    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();

        if(!player.hasPermission(plugin.getConfig().getString("World-Event.block-break.permission"))){
            player.sendMessage(plugin.getConfig().getString("World-Event.block-break.permission-message"));
        }
    }
}
