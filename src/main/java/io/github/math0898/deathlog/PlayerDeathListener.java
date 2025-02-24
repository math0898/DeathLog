package io.github.math0898.deathlog;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
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
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true) // todo: Config values
    public void onPlayerDeath (PlayerDeathEvent event) {
        Player player = event.getPlayer(); // todo: Support colors and styles.
        Component lastWords = LastWords.getInstance().getLastWords(player.getUniqueId());
        if (lastWords == null)
            lastWords = Component.text("");
        Component deathMessage = event.deathMessage();
        if (deathMessage == null)
            deathMessage = Component.text("");
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 0.5f, 1.0f);
            p.showTitle(Title.title(deathMessage, Component.text("Last Words: ").append(lastWords)));
        }
    }
}
