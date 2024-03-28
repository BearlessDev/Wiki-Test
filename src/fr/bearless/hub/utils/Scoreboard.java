package fr.bearless.hub.utils;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard implements Listener {

    public void setScoreboard(Player player) {
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String group = user.getCachedData().getMetaData().getPrimaryGroup().replace("&", "§");

        Objective obj = Bukkit.getScoreboardManager().getNewScoreboard().registerNewObjective("Lobby-1", "Dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§c§lBearless'Serv");

        obj.getScore("§eEn Lignes: §f" + Bukkit.getOnlinePlayers().size()).setScore(0);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        setScoreboard(player);
    }
}