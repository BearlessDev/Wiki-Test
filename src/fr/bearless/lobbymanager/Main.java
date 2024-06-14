package fr.bearless.lobbymanager;

import fr.bearless.lobbymanager.commands.ReloadCmd;
import fr.bearless.lobbymanager.commands.SpawnCmd;
import fr.bearless.lobbymanager.listerners.PlayersEvent;
import fr.bearless.lobbymanager.listerners.PlayersTablist;
import fr.bearless.lobbymanager.listerners.WorldEvent;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("lm-reload").setExecutor(new ReloadCmd(this));
        getCommand("lm-spawn").setExecutor(new SpawnCmd(this));

        getServer().getPluginManager().registerEvents(new WorldEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayersEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayersTablist(this), this);

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
        }
    }

    @Override
    public void onDisable() {
    }

    public boolean isDefaultJoinMessageDisabled(){
        return getConfig().getBoolean("server.disable_default_join_message");
    }

    public boolean isDefaultQuitMessageDisabled(){
        return getConfig().getBoolean("server.disable_default_quit_message");
    }

    public String getCustomJoinMessage(Player player){
        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
        String prefix = user.getCachedData().getMetaData().getPrefix().replace("&", "§");

        return ChatColor.translateAlternateColorCodes('&', getConfig().getString("server.custom_join_message")
                .replaceAll("%prefix%", prefix));
    }
}