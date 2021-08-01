package scifi.scifi.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import scifi.scifi.player.PlayerManager;
import scifi.scifi.player.ScifiPlayer;

public class OnQuitListener implements Listener {

    private final PlayerManager playerManager;

    public OnQuitListener(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        ScifiPlayer scifiPlayer = playerManager.handlePlayerQuit(player);
        assert(scifiPlayer != null);
        sendQuitMessage(scifiPlayer);
    }

    public void sendQuitMessage(ScifiPlayer scifiPlayer) {
        Bukkit.getServer().sendMessage(Component.text(ChatColor.RED + scifiPlayer.getName() + " quit the server!"));
    }

}
