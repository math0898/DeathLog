package io.github.math0898.deathlog;

import io.papermc.paper.event.player.AsyncChatEvent;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The LastWord's class is a singleton class tasked with tracking the last words or command ran by a player.
 *
 * @author Sugaku
 */
public class LastWords implements Listener {

    /**
     * The active LastWords instance.
     * -- GETTER --
     * Accessor method for the active LastWords instance.
     *
     * @return The current LastWords instance.
     */
    @Getter
    private static final LastWords instance = new LastWords();

    /**
     * A collection of the last words sent by players. Some of these may be commands.
     */
    private final Map<UUID, Component> lastWords = new HashMap<>();

    /**
     * Accessor method for the last words of the given player.
     *
     * @param uuid The uuid of the player in interest.
     * @return This player's last words, or null if none present.
     */
    public Component getLastWords (UUID uuid) {
        return lastWords.get(uuid);
    }

    /**
     * Called whenever a chat message is sent.
     *
     * @param event The chat message event.
     */
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onMessage (AsyncChatEvent event) {
        ConfigManager manager = ConfigManager.getInstance();
        if (!manager.isLastWordsEnabled() || !manager.isLastWordsMessages()) return;
        lastWords.put(event.getPlayer().getUniqueId(), event.message());
    }

    /**
     * Called whenever a command is run.
     *
     * @param event The command pre-execute event to intercept.
     */
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onCommandUse (PlayerCommandPreprocessEvent event) {
        ConfigManager manager = ConfigManager.getInstance();
        if (!manager.isLastWordsEnabled() || !manager.isLastWordsCommands()) return;
        lastWords.put(event.getPlayer().getUniqueId(), Component.text(event.getMessage().split(" ")[0]));
    }
}
