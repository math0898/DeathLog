package io.github.math0898.deathlog;

import io.github.math0898.deathlog.commands.DeathLogCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The DeathLog plugin main class.
 *
 * @author Sugaku
 */
public final class DeathLog extends JavaPlugin {

    /**
     * The active DeathLog instance.
     */
    private static DeathLog plugin;

    /**
     * An accessor method for the active DeathLog instance.
     *
     * @return The active DeathLog instance.
     */
    public static DeathLog getInstance () {
        return plugin;
    }

    /**
     * Called when the DeathLog plugin is enabled.
     */
    @Override
    public void onEnable () {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(LastWords.getInstance(), this);
        new DeathLogCommand();
    }
}
