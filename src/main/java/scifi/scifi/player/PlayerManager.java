package scifi.scifi.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final Map<UUID, ScifiPlayer> scifiPlayerMap = new HashMap<>();

    public ScifiPlayer handlePlayerJoin(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        ScifiPlayer scifiPlayer = scifiPlayerMap.get(playerUniqueId);
        if (scifiPlayer == null) {
            scifiPlayer = new ScifiPlayer(playerUniqueId);
            scifiPlayerMap.put(playerUniqueId, scifiPlayer);
        }
        return scifiPlayer;
    }

    public ScifiPlayer handlePlayerQuit(Player player) {
        return scifiPlayerMap.remove(player.getUniqueId());
    }
}
