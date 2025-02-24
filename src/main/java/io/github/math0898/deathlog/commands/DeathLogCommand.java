package io.github.math0898.deathlog.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.github.math0898.deathlog.ConfigManager;
import io.github.math0898.utils.Utils;
import io.github.math0898.utils.commands.BetterCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

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
        Commands.literal("deathlog").executes(this::onCommandExecute).build();
    }

    // todo: Refactor
    public int onCommandExecute (CommandContext<CommandSourceStack> ctx) {
        if (ctx.getSource().getSender().hasPermission("deathlog.reload")) {
            ConfigManager.reInstantiate();
            send(ctx.getSource().getSender(), "Config reloaded");
        }
        return Command.SINGLE_SUCCESS;
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
