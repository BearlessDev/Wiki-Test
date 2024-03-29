package fr.bearless.lobbymanager;

import fr.bearless.lobbymanager.commands.reloadCmd;
import fr.bearless.lobbymanager.commands.spawnCmd;
import fr.bearless.lobbymanager.listerners.PlayersEvent;
import fr.bearless.lobbymanager.listerners.WorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("lm-reload").setExecutor(new reloadCmd(this));
        getCommand("lm-spawn").setExecutor(new spawnCmd(this));

        getServer().getPluginManager().registerEvents(new WorldEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayersEvent(this), this);
    }

    @Override
    public void onDisable() {
    }
}
