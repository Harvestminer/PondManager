package me.harvestminer.pondmanager;

import org.bukkit.Location;

public class WarpManager
{
	private Location loc;

	public Location getWarpLocation(String warp)
	{
		if (this.loc == null)
		{
			Location loc = null;

			Object t = PondManager.getInstance().getConfig().get(String.format("%sLocation", warp));
			if (t instanceof Location)
				loc = (Location) t;

			this.loc = loc;
		}

		return this.loc;
	}

	public void setWarpLocation(Location location, String warp)
	{
		this.loc = location;

		PondManager.getInstance().getConfig().set(String.format("%sLocation", warp), loc);
		PondManager.getInstance().saveConfig();
	}
}
