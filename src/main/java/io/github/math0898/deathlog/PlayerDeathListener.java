package io.github.math0898.deathlog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * The main class in handling the situation when a player dies.
 *
 * @author Sugaku
 */
public class PlayerDeathListener implements Listener {

    /**
     * Called when a player dies.
     *
     * @param event The player death event to interact with.
     */
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerDeath (PlayerDeathEvent event) {
        // todo: Implement.
    }
}
