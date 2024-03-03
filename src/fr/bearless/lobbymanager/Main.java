package fr.bearless.lobbymanager;

import fr.bearless.lobbymanager.listerners.WorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new WorldEvent(this), this);
    }

    @Override
    public void onDisable() {
    }
}
