package scifi.scifi.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import scifi.scifi.McScifi;
import scifi.scifi.player.PlayerManager;
import scifi.scifi.player.ScifiPlayer;
import scifi.scifi.supabase.Connection;

import java.io.IOException;

public class OnJoinListener implements Listener {

    private final PlayerManager playerManager;
    private Connection conn = new Connection();

    public OnJoinListener(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException, InterruptedException {
        Player player = event.getPlayer();
        ScifiPlayer scifiPlayer = playerManager.handlePlayerJoin(player);
        event.joinMessage(constructJoinMessage(scifiPlayer));
        Bukkit.getLogger().info(conn.getRequest("https://ypallacrxhalhdrkcbug.supabase.co/rest/v1/player?select=*").body());
    }

    private Component constructJoinMessage(ScifiPlayer scifiPlayer) {
        return Component.text(ChatColor.GREEN + scifiPlayer.getName() + " joined the server!");
    }

}
