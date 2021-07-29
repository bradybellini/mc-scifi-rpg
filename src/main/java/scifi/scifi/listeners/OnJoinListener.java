package scifi.scifi.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import scifi.scifi.player.PlayerManager;
import scifi.scifi.player.ScifiPlayer;

public class OnJoinListener implements Listener {

    private final PlayerManager playerManager;

    public OnJoinListener(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ScifiPlayer scifiPlayer = playerManager.handlePlayerJoin(player);
        sendJoinMessage(scifiPlayer);
    }

    private void sendJoinMessage(ScifiPlayer scifiPlayer) {
        Bukkit.getServer().sendMessage(Component.text(ChatColor.GREEN + scifiPlayer.getName() + " joined the server!"));
    }

}
