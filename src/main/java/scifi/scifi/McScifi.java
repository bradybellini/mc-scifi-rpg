package scifi.scifi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import scifi.scifi.listeners.OnJoinListener;

public final class McScifi extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerEvents();
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new OnJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
