package me.harvestminer.pondmanager.commands;

import me.harvestminer.pondmanager.WarpManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class C_WarpTP implements CommandExecutor
{
	private final WarpManager manager;
	private final String warp;

	public C_WarpTP (String name, WarpManager manager)
	{
		this.warp = name;
		this.manager = manager;
	}

	// This method is called, when somebody uses our command
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
	{
		if (!(commandSender instanceof Player))
			return false;

		if (manager.getWarpLocation(warp) == null)
		{
			commandSender.sendMessage(Component.text("Failed: That warp has not been set."));
			return false;
		}

		((Player) commandSender).teleport(manager.getWarpLocation(warp));

		return true;
	}
}
