package me.harvestminer.pondmanager;

import me.harvestminer.pondmanager.commands.C_WarpSet;
import me.harvestminer.pondmanager.commands.C_WarpTP;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PondManager extends JavaPlugin
{
	public static PondManager getInstance()
	{
		return manager;
	}
	private static PondManager manager;

	@Override
	public void onEnable()
	{
		manager = this;

		AddCommand("market");
		AddCommand("games");

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	@Override
	public void onDisable()
	{
		// Plugin shutdown logic
	}

	private void AddCommand(String command)
	{
		PluginCommand comSet = this.getCommand(String.format("set%s", command));
		PluginCommand comTP = this.getCommand(command);

		WarpManager warpManager = new WarpManager();

		if (comSet != null)
			comSet.setExecutor(new C_WarpSet(command, warpManager));
		if (comTP != null)
			comTP.setExecutor(new C_WarpTP(command, warpManager));

		this.getConfig().addDefault(String.format("%sLocation", command), null);
	}
}
