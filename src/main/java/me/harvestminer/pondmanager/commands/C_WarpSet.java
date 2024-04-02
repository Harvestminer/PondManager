package me.harvestminer.pondmanager.commands;

import me.harvestminer.pondmanager.WarpManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class C_WarpSet implements CommandExecutor
{
	private final WarpManager manager;
	private final String warp;

	public C_WarpSet (String name, WarpManager manager)
	{
		this.warp = name;
		this.manager = manager;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
	{
		if (!(commandSender instanceof Player))
			return false;

		manager.setWarpLocation(((Player) commandSender).getLocation(), warp);
		commandSender.sendMessage(Component.text("Warp has been set."));

		return true;
	}
}
