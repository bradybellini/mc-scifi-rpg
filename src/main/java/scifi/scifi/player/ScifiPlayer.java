package scifi.scifi.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ScifiPlayer {

    private final UUID uniqueId;
    private final transient String name;

    public ScifiPlayer(UUID uniqueId) {
        this.uniqueId = uniqueId;
        this.name = Bukkit.getPlayer(uniqueId).getName();
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uniqueId);
    }

    public String getName() {
        return name;
    }

}
