package io.github.math0898.deathlog;

import lombok.Getter;

/**
 * Reads and makes accessible configuration values from config.yml.
 *
 * @author Sugaku
 */
public class ConfigManager {

    /**
     * The singleton instance of the ConfigManager.
     * -- GETTER --
     * Accessor method for the ConfigManager singleton.
     *
     * @return The current ConfigManager.
     */
    @Getter
    private static ConfigManager instance = new ConfigManager();

    /**
     * Creates the ConfigManager by reading configuration values.
     */
    private ConfigManager () {
        // todo: Implement.
    }

    /**
     * Recreates the ConfigManager.
     */
    public static void reInstantiate () {
        instance = new ConfigManager();
    }
}
