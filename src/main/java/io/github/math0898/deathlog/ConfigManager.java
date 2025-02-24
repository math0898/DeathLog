package io.github.math0898.deathlog;

import io.github.math0898.utils.Utils;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

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
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final String messageDeathMessage;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final String messageLastWords;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final String messageSoundType;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final double messageSoundVolume;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final double messageSoundPitch;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final boolean lastWordsEnabled;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final boolean lastWordsCommands;

    /**
     * todo: Field javadoc
     * -- GETTER --
     * todo: Method javadoc
     *
     * @return todo: Return javadoc
     */
    @Getter
    private final boolean lastWordsMessages;

    /**
     * Creates the ConfigManager by reading configuration values.
     */
    private ConfigManager () {
        Utils.getPlugin().saveDefaultConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("./plugins/DeathLog/config.yml"));
        messageDeathMessage = config.getString("message.death-message", "%s");
        messageLastWords = config.getString("message.last-words", "Last Words: %s");
        messageSoundType = config.getString("message.sound.type", "ENTITY_SLIME_JUMP");
        messageSoundVolume = config.getDouble("message.sound.volume", 0.5);
        messageSoundPitch = config.getDouble("message.sound.pitch", 1.0);
        lastWordsEnabled = config.getBoolean("last-words.enabled", true);
        lastWordsCommands = config.getBoolean("last-words.commands", true);
        lastWordsMessages = config.getBoolean("last-words.messages", true);
    }

    /**
     * Recreates the ConfigManager.
     */
    public static void reInstantiate () {
        instance = new ConfigManager();
    }
}
