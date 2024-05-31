package fr.bearless.lobbymanager.listerners;

import fr.bearless.lobbymanager.Main;
import fr.bearless.lobbymanager.Tables.tablist;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayersTablist implements Listener {

    final Main plugin;

    public PlayersTablist(Main main) {
        this.plugin = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String header = plugin.getConfig().getString("player.tablist_header").replace("&", "§");
        String footer = plugin.getConfig().getString("player.tablist_footer").replace("&", "§");

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String prefix = user.getCachedData().getMetaData().getPrefix().replace("&", "§");

        String format = plugin.getConfig().getString("player.tablist_format").replace("&", "§").replaceAll("%prefix%", prefix).replaceAll("%player%", player.getName());

        tablist.sendtoPlayer(player, header, footer);

        player.setPlayerListName(format);
    }
}
