package fr.bearless.hub;

import fr.bearless.hub.utils.Scoreboard;
import fr.bearless.hub.commands.gmCmd;
import fr.bearless.hub.commands.spawnCmd;
import fr.bearless.hub.events.JoinQuit;
import fr.bearless.hub.events.world;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("gm").setExecutor(new gmCmd());
        getCommand("spawn").setExecutor(new spawnCmd());

        getServer().getPluginManager().registerEvents(new JoinQuit(), this);
        getServer().getPluginManager().registerEvents(new world(), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(), this);

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if(provider != null) {
            LuckPerms api = provider.getProvider();
        }
    }

    @Override
    public void onDisable() {
    }
}
