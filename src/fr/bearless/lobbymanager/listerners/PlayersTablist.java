package fr.bearless.lobbymanager.listerners;

import fr.bearless.lobbymanager.Main;
import fr.bearless.lobbymanager.Tables.tablist;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayersTablist implements Listener {

    private Main plugin;

    public PlayersTablist(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String header = plugin.getConfig().getString("player.tablist_header").replace("&", "§");
        String footer = plugin.getConfig().getString("player.tablist_footer").replace("&", "§");

        tablist.sendtoPlayer(player, header, footer);
    }
}
