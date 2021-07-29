package scifi.scifi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import scifi.scifi.listeners.OnJoinListener;
import scifi.scifi.player.PlayerManager;

public final class McScifi extends JavaPlugin {

    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        initializeManagers();

        registerEvents();
    }

    private void initializeManagers() {
        this.playerManager = new PlayerManager();
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new OnJoinListener(playerManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
