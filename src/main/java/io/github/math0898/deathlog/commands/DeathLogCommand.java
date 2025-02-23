package io.github.math0898.deathlog.commands;

import io.github.math0898.utils.commands.BetterCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * The DeathLog command can be used by admins to enable, disable, and reload DeathLog. For all users it can be used to
 * disable DeathLog messages.
 *
 * @author Sugaku
 */
public class DeathLogCommand extends BetterCommand {

    /**
     * Creates the DeathLogCommand runner.
     */
    public DeathLogCommand () {
        super("deathlog", ChatColor.DARK_GRAY + "[" + ChatColor.RED + "DL" + ChatColor.DARK_GRAY + "] ");
    }

    /**
     * Called whenever specifically a player executes this command.
     *
     * @param player The player who ran this command.
     * @param args   The arguments they passed to the command.
     */
    @Override
    public boolean onPlayerCommand (Player player, String[] args) {
        return false;
    }

    /**
     * Called whenever an unspecified sender executes this command. This could include console and command blocks.
     *
     * @param sender The sender who ran this command.
     * @param args   The arguments they passed to the command.
     */
    @Override
    public boolean onNonPlayerCommand (CommandSender sender, String[] args) {
        return false;
    }

    /**
     * Called whenever a command sender is trying to tab complete a command.
     *
     * @param sender The sender who is tab completing this command.
     * @param args   The current arguments they have typed.
     */
    @Override
    public List<String> simplifiedTab (CommandSender sender, String[] args) {
        return List.of();
    }
}
